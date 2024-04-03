package com.coderscampus.assignment6;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class SalesService {
	
    public static Sale createSalesFromStrings(String dateString, String salesString) {
        // Defensive programming
        if (dateString == null || dateString.isEmpty() || salesString == null || salesString.isEmpty()) {
            throw new IllegalArgumentException("Invalid date or sales data: " + dateString + ", " + salesString);
        }
        Month month = DateService.parseMonthFromCSV(dateString);
        Integer year = DateService.parseYearFromCSV(dateString);
        Integer sales = Integer.parseInt(salesString);
        return new Sale(month, year, sales);
    }

    public static void printYearlySalesReport(String modelName, List<Sale> salesData) {
        printReportHeader(modelName);
        Map<Integer, Integer> yearlySales = retrieveYearlySales(salesData);
        yearlySales.forEach((year, sales) -> System.out.println(year + " -> " + sales));
        System.out.println();
        printBestSalesMonth(modelName, salesData);
        printWorstSalesMonth(modelName, salesData);
    }

    private static void printReportHeader(String modelName) {
        System.out.println(modelName + " Yearly Sales Report");
        System.out.println("----------------------");
    }

    public static Map<Integer, Integer> retrieveYearlySales(List<Sale> salesData) {
        return salesData.stream()
                .collect(Collectors.groupingBy(Sale::getYear, Collectors.summingInt(Sale::getSale)));
    }

    private static void printBestSalesMonth(String modelName, List<Sale> salesData) {
        Optional<Sale> best = bestMonth(salesData);
        best.ifPresent(sale -> System.out.println("The best month for " + modelName + " was: " + DateService.formatMonthYear(sale.getMonth(), sale.getYear())));
    }

    private static void printWorstSalesMonth(String modelName, List<Sale> salesData) {
        Optional<Sale> worst = worstMonth(salesData);
        worst.ifPresent(sale -> System.out.println("The worst month for " + modelName + " was: " + DateService.formatMonthYear(sale.getMonth(), sale.getYear())));
        System.out.println();
    }

    public static Optional<Sale> bestMonth(List<Sale> salesData) {
        return salesData.stream().max(Comparator.comparingInt(Sale::getSale));
    }

    public static Optional<Sale> worstMonth(List<Sale> salesData) {
        return salesData.stream().min(Comparator.comparingInt(Sale::getSale));
    }

}