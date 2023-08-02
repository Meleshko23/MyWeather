package org.tasc;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * Класс для записи данных о погоде в файл Excel.
 */
public class ExcelWriter {

    /**
     * Записывает данные о погоде в файл Excel.
     *
     * @param weatherDataList Список объектов WeatherData с данными о погоде.
     * @param filePath        Абсолютный путь к файлу, в который будут записаны данные.
     */
    public void writeDataToExcel(List<WeatherData> weatherDataList, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Weather Data");

            // Создаем заголовок для таблицы Excel
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("City");
            headerRow.createCell(1).setCellValue("Temperature");
            headerRow.createCell(2).setCellValue("Weather Description");

            // Записываем данные о погоде в таблицу Excel
            int rowNum = 1;
            for (WeatherData weatherData : weatherDataList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(weatherData.getCityName());
                row.createCell(1).setCellValue(weatherData.getTemperature());
                row.createCell(2).setCellValue(weatherData.getWeatherDescription());
            }

            // Автоматически устанавливаем ширину столбцов
            for (int i = 0; i < 3; i++) {
                sheet.autoSizeColumn(i);
            }

            // Сохраняем файл Excel
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
