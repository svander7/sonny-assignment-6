package com.coderscampus.assignment6;

import java.time.Month;

public class Sale {

    //Instance Variables
    private Month month;
    private Integer year;
    private Integer sale;

    // Constructor
    public Sale(Month month, Integer year, Integer sale) {
        this.month = month;
        this.year = year;
        this.sale = sale;
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

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "domain.Sale{" +
                "month='" + month + '\'' +
                ", year=" + year +
                ", sale=" + sale +
                '}';
    }
}