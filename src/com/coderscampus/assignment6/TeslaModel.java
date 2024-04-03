package com.coderscampus.assignment6;

public enum TeslaModel {
	
    MODEL_3("Model 3", "model3.csv"),
    MODEL_S("Model S", "modelS.csv"),
    MODEL_X("Model_X", "modelX.csv");

    private final String displayName;
    private final String csvFileName;

    TeslaModel(String displayName, String csvFileName) {
        this.displayName = displayName;
        this.csvFileName = csvFileName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCsvFileName() {
        return csvFileName;
    }

}