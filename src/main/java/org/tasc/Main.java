package org.tasc;

import java.nio.file.Paths;
import java.util.*;

/**
 * Главный класс приложения, запускает получение данных о погоде и запись в Excel.
 */
public class Main {
    /**
     * Точка входа в приложение.
     *
     * @param args Параметры командной строки.
     */
    public static void main(String[] args) {
        // API ключ для доступа к API Яндекс.Погода
        String yandexApiKey = "5aad068b-8924-4cfe-ab53-53106c0f6176";

        // Создаем объект WeatherService для получения данных о погоде
        WeatherService weatherService = new WeatherService(yandexApiKey);

        // Получаем данные о погоде для крупных городов России
        List<WeatherData> weatherDataList = weatherService.getWeatherData();

        // Определяем путь к рабочему столу пользователя
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        String filePath = Paths.get(desktopPath, "WeatherData.xlsx").toString();

        // Создаем объект ExcelWriter для записи данных о погоде в файл Excel
        ExcelWriter excelWriter = new ExcelWriter();

        // Записываем данные о погоде в файл Excel на рабочем столе
        excelWriter.writeDataToExcel(weatherDataList, filePath);

        // Выводим сообщение об успешной записи данных в файл Excel
        System.out.println("Данные успешно записаны в Excel. Расположение файла: " + filePath);
    }
}

