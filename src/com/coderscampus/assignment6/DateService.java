package com.coderscampus.assignment6;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateService {

    private static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("MMM-yy", Locale.US);
    private static final DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");

    public static Month parseMonthFromCSV(String dateString) {
        return Month.from(MONTH_FORMATTER.parse(dateString));
    }

    public static Integer parseYearFromCSV(String dateString) {
        int twoDigitYear = Integer.parseInt(dateString.split("-")[1]);
        return 2000 + twoDigitYear;
    }

    public static String formatMonthYear(Month month, Integer year) {
        LocalDate date = LocalDate.of(year, month, 1);
        return date.format(YEAR_MONTH_FORMATTER);
    }

}