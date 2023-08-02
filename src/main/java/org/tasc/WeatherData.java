package org.tasc;

/**
 * Класс для хранения данных о погоде.
 */
class WeatherData {
    private String cityName;
    private String temperature;
    private String weatherDescription;

    /**
     * Конструктор для создания объекта WeatherData.
     *
     * @param cityName           Название города.
     * @param temperature        Температура.
     * @param weatherDescription Описание погоды.
     */
    public WeatherData(String cityName, String temperature, String weatherDescription) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.weatherDescription = weatherDescription;
    }

    public String getCityName() {
        return cityName;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    @Override
    public String toString() {
        return "City: " + cityName + ", Temperature: " + temperature + ", Weather: " + weatherDescription;
    }
}
