package org.tasc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.List;

public class WeatherServiceTest {

    @Test
    public void testGetWeatherDataForCity_Success() throws IOException {
        // Arrange
        String cityName = "City";
        double latitude = 55.0;
        double longitude = 37.0;
        WeatherData expectedData = new WeatherData(cityName, "25°C", "Sunny");

        WeatherDataUtil.CITY_LATITUDE_MAP.put(cityName, latitude);
        WeatherDataUtil.CITY_LONGITUDE_MAP.put(cityName, longitude);

        WeatherService weatherService = new WeatherService("your_api_key_here");
        WeatherService spyWeatherService = spy(weatherService);
        doReturn(expectedData).when(spyWeatherService).getWeatherDataForCity(cityName);

        // Act
        WeatherData weatherData = spyWeatherService.getWeatherDataForCity(cityName);

        // Assert
        assertNotNull(weatherData);
        assertEquals(expectedData, weatherData);
    }

    @Test
    public void testGetWeatherDataForCity_Failure() throws IOException {
        // Arrange
        String cityName = "NonExistentCity";
        double latitude = 0.0;
        double longitude = 0.0;

        WeatherDataUtil.CITY_LATITUDE_MAP.put(cityName, latitude);
        WeatherDataUtil.CITY_LONGITUDE_MAP.put(cityName, longitude);

        WeatherService weatherService = new WeatherService("your_api_key_here");
        WeatherService spyWeatherService = spy(weatherService);
        doCallRealMethod().when(spyWeatherService).getWeatherDataForCity(cityName);

        // Act
        WeatherData weatherData = spyWeatherService.getWeatherDataForCity(cityName);

        // Assert
        assertNull(weatherData);
    }
}

