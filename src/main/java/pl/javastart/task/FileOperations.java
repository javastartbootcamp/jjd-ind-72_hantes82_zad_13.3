package pl.javastart.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

    public static List<CurrencyCourse> getCurrencyCoursesFromFile(String filePath) {
        List<CurrencyCourse> currencyCourses = new ArrayList<>();
        File file = new File(filePath);
        try (
                Scanner scan = new Scanner(file);
                ) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] arrayCurrency = line.split(";");
                BigDecimal changePrice =  new BigDecimal(arrayCurrency[1]);
                currencyCourses.add(new CurrencyCourse(arrayCurrency[0], changePrice));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku");;
        }
        return  currencyCourses;
    }

    public static List<Product> getProductsFromFile(String filePath) {
        List<Product> products = new ArrayList<>();
        File file = new File(filePath);
        try (
                Scanner scan = new Scanner(file);
                ) {

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] arrayCurrency = line.split(";");
                BigDecimal price = new BigDecimal(arrayCurrency[1]);
                products.add(new Product(arrayCurrency[0], price, arrayCurrency[2]));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku");;
        }
        return products;
    }
}
