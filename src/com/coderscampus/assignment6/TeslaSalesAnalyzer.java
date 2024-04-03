package com.coderscampus.assignment6;

import java.util.List;

public class TeslaSalesAnalyzer {
	
	public static void main(String[] args) {
        for(TeslaModel model : TeslaModel.values()) {
            List<Sale> salesData = FileService.readCSV(model.getCsvFileName());
            SalesService.printYearlySalesReport(model.getDisplayName(), salesData);
        }
    }
}