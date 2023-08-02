package org.tasc;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для получения данных о погоде для крупных городов России с использованием API Яндекс.Погода.
 */
public class WeatherService {
    private final String yandexApiKey;

    /**
     * Конструктор для создания объекта WeatherService.
     *
     * @param yandexApiKey API ключ Яндекс.Погода.
     */
    public WeatherService(String yandexApiKey) {
        this.yandexApiKey = yandexApiKey;
    }

    /**
     * Получает данные о погоде для крупных городов России.
     *
     * @return Список объектов WeatherData с данными о погоде.
     */
    public List<WeatherData> getWeatherData() {
        List<WeatherData> weatherDataList = new ArrayList<>();

        for (String city : WeatherDataUtil.CITY_URL_MAP.keySet()) {
            try {
                WeatherData weatherData = getWeatherDataForCity(city);
                if (weatherData != null) {
                    weatherDataList.add(weatherData);
                }
            } catch (IOException e) {
                System.err.println("Error fetching data for city: " + city);
                e.printStackTrace();
            }
        }
        return weatherDataList;
    }

    /**
     * Получает данные о погоде для заданного города.
     *
     * @param city Название города, для которого нужно получить данные о погоде.
     * @return Объект WeatherData с данными о погоде для указанного города или null, если данные недоступны или произошла ошибка.
     * @throws IOException Возникает, если произошла ошибка при отправке запроса или чтении ответа.
     */
    protected WeatherData getWeatherDataForCity(String city) throws IOException {
        double lat = WeatherDataUtil.CITY_LATITUDE_MAP.getOrDefault(city, 0.0);
        double lon = WeatherDataUtil.CITY_LONGITUDE_MAP.getOrDefault(city, 0.0);

        String apiUrl = "https://api.weather.yandex.ru/v2/forecast";
        String queryString = apiUrl + "?lat=" + lat + "&lon=" + lon + "&extra=true";

        URL url = new URL(queryString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-Yandex-API-Key", yandexApiKey);

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }

                WeatherData weatherData = parseJsonResponse(response.toString(), city);
                return weatherData;
            }
        }
        return null;
    }

    /**
     * Разбирает JSON-ответ и создает объект WeatherData с данными о погоде.
     *
     * @param responseBody JSON-ответ от API Яндекс.Погода.
     * @param cityName     Название города, для которого получены данные.
     * @return Объект WeatherData с данными о погоде для указанного города или null, если данные недоступны или произошла ошибка.
     */
    private WeatherData parseJsonResponse(String responseBody, String cityName) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
        JsonObject geoObject = jsonObject.getAsJsonObject("geo_object");
        JsonObject fact = jsonObject.getAsJsonObject("fact");

        String locationName = geoObject.getAsJsonObject("locality").get("name").getAsString();
        String temperature = fact.get("temp").getAsString() + "°C";
        String weatherDescription = fact.get("condition").getAsString();

        return new WeatherData(locationName, temperature, weatherDescription);
    }
}
