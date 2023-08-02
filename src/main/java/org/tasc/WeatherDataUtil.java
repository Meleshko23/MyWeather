package org.tasc;

import java.util.HashMap;
import java.util.Map;

/**
 * Утилитный класс для хранения информации о крупных городах России и URL-адресах для получения данных о погоде.
 */
public class WeatherDataUtil {
    public static final Map<String, String> CITY_URL_MAP = new HashMap<>();
    public static final Map<String, Double> CITY_LATITUDE_MAP = new HashMap<>();
    public static final Map<String, Double> CITY_LONGITUDE_MAP = new HashMap<>();

    static {
        CITY_URL_MAP.put("Москва", "https://api.weather.yandex.ru/v2/forecast?lat=55.75396&lon=37.620393&extra=true");
        CITY_URL_MAP.put("Санкт-Петербург", "https://api.weather.yandex.ru/v2/forecast?lat=59.9342802&lon=30.3350986&extra=true");
        CITY_URL_MAP.put("Новосибирск", "https://api.weather.yandex.ru/v2/forecast?lat=55.0083526&lon=82.9357327&extra=true");
        CITY_URL_MAP.put("Екатеринбург", "https://api.weather.yandex.ru/v2/forecast?lat=56.8389261&lon=60.6057025&extra=true");
        CITY_URL_MAP.put("Нижний Новгород", "https://api.weather.yandex.ru/v2/forecast?lat=56.2965039&lon=43.936059&extra=true");
        CITY_URL_MAP.put("Казань", "https://api.weather.yandex.ru/v2/forecast?lat=55.755826&lon=49.131225&extra=true");
        CITY_URL_MAP.put("Челябинск", "https://api.weather.yandex.ru/v2/forecast?lat=55.1644419&lon=61.4368432&extra=true");
        CITY_URL_MAP.put("Омск", "https://api.weather.yandex.ru/v2/forecast?lat=54.9884804&lon=73.3242361&extra=true");
        CITY_URL_MAP.put("Самара", "https://api.weather.yandex.ru/v2/forecast?lat=53.1951651&lon=50.1067691&extra=true");
        CITY_URL_MAP.put("Ростов-на-Дону", "https://api.weather.yandex.ru/v2/forecast?lat=47.2357137&lon=39.701505&extra=true");

        CITY_LATITUDE_MAP.put("Москва", 55.75396);
        CITY_LATITUDE_MAP.put("Санкт-Петербург", 59.9342802);
        CITY_LATITUDE_MAP.put("Новосибирск", 55.0083526);
        CITY_LATITUDE_MAP.put("Екатеринбург", 56.8389261);
        CITY_LATITUDE_MAP.put("Нижний Новгород", 56.2965039);
        CITY_LATITUDE_MAP.put("Казань", 55.755826);
        CITY_LATITUDE_MAP.put("Челябинск", 55.1644419);
        CITY_LATITUDE_MAP.put("Омск", 54.9884804);
        CITY_LATITUDE_MAP.put("Самара", 53.1951651);
        CITY_LATITUDE_MAP.put("Ростов-на-Дону", 47.2357137);

        CITY_LONGITUDE_MAP.put("Москва", 37.620393);
        CITY_LONGITUDE_MAP.put("Санкт-Петербург", 30.3350986);
        CITY_LONGITUDE_MAP.put("Новосибирск", 82.9357327);
        CITY_LONGITUDE_MAP.put("Екатеринбург", 60.6057025);
        CITY_LONGITUDE_MAP.put("Нижний Новгород", 43.936059);
        CITY_LONGITUDE_MAP.put("Казань", 49.131225);
        CITY_LONGITUDE_MAP.put("Челябинск", 61.4368432);
        CITY_LONGITUDE_MAP.put("Омск", 73.3242361);
        CITY_LONGITUDE_MAP.put("Самара", 50.1067691);
        CITY_LONGITUDE_MAP.put("Ростов-на-Дону", 39.701505);
    }
}

