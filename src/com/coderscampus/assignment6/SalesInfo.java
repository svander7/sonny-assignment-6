package com.coderscampus.assignment6;

import java.time.Month;

public class SalesInfo {
	
	 //Instance Variables
    private Month month;
    private Integer year;
    private Integer sales;

    // Constructor
    public SalesInfo(Month month, Integer year, Integer sales) {
        this.month = month;
        this.year = year;
        this.sales = sales;
    }
    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "domain.Sale{" +
                "month='" + month + '\'' +
                ", year=" + year +
                ", sales=" + sales +
                '}';
    }
}