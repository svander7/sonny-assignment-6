package com.coderscampus.assignment6;

import java.util.List;

public class TeslaSalesAnalyzer {
	
    public static void main(String[] args) {
        for(Models model : Models.values()) {
            List<SalesInfo> salesData = File.readCSV(model.getCsvFileName());
            Sale.printYearlySalesReport(model.getDisplayName(), salesData);
        }
    }
}