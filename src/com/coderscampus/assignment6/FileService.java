package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static List<Sale> readCSV(String fileName) {
        List<Sale> salesData;

        try (BufferedReader reader = createBufferedReader(fileName)) {
            skipHeader(reader);
            salesData = processLines(reader);
        } catch (FileNotFoundException e) {
            throw new FileReadException("File not found: " + fileName, e);
        } catch (IOException e) {
            throw new FileProcessingException("Error processing file: " + fileName, e);
        }
        return salesData;
    }

    private static BufferedReader createBufferedReader(String fileName) throws FileNotFoundException {
        return new BufferedReader(new FileReader(fileName));
    }

    private static void skipHeader(BufferedReader reader) throws IOException {
        reader.readLine();
    }

    private static List<Sale> processLines(BufferedReader reader) throws IOException {
        List<Sale> salesData = new ArrayList<>();
        String line;
        while((line = reader.readLine()) != null) {
            Sale sale = convertLineToSale(line);
            salesData.add(sale);
        }
        return salesData;
    }

    private static Sale convertLineToSale(String line) {
        String[] values = line.split(",");
        // Defensive programming
        if (values.length < 2) {
            throw new IllegalArgumentException("Invalid CSV line format: " + line);
        }
        return SalesService.createSalesFromStrings(values[0], values[1]);
    }

    static class FileReadException extends RuntimeException {
        public FileReadException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    static class FileProcessingException extends RuntimeException {
        public FileProcessingException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}