package pl.javastart.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String productsFile = "src/main/resources/products.csv";
        String currenciesFile = "src/main/resources/currencies.csv";
        List<CurrencyCourse> courses = FileOperations.getCurrencyCoursesFromFile(currenciesFile);
        List<Product> products = FileOperations.getProductsFromFile(productsFile);
        Statistics.showStatistics(courses, products);

    }

}
