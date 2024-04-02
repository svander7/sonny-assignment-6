package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class TeslaSalesAnalyzer {

    public static void main(String[] args) {
        Map<YearMonth, Integer> salesData = readSalesData("model3.csv");

        int bestMonthSales = Integer.MIN_VALUE;
        int worstMonthSales = Integer.MAX_VALUE;
        YearMonth bestMonth = null;
        YearMonth worstMonth = null;

        for (Map.Entry<YearMonth, Integer> entry : salesData.entrySet()) {
            YearMonth month = entry.getKey();
            int sales = entry.getValue();

            if (sales > bestMonthSales) {
                bestMonthSales = sales;
                bestMonth = month;
            }

            if (sales < worstMonthSales) {
                worstMonthSales = sales;
                worstMonth = month;
            }
        }

        // Print the results
        System.out.println("Model 3 Yearly Sales Report");
        System.out.println("---------------------------");
        System.out.println("2017 -> " + salesData.getOrDefault(YearMonth.of(2017, 1), 0));
        System.out.println("2018 -> " + salesData.getOrDefault(YearMonth.of(2018, 1), 0));
        System.out.println("2019 -> " + salesData.getOrDefault(YearMonth.of(2019, 1), 0));
        System.out.println("\nThe best month for Model 3 was: " + bestMonth);
        System.out.println("The worst month for Model 3 was: " + worstMonth);
    }

    private static Map<YearMonth, Integer> readSalesData(String filePath) {
        Map<YearMonth, Integer> salesData = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String dateStr = parts[0];
                    int sales = Integer.parseInt(parts[1]);
                    YearMonth yearMonth = YearMonth.parse(dateStr);
                    salesData.put(yearMonth, sales);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return salesData;
    }
}