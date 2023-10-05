package pl.javastart.task;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Statistics {

    private static List<Product> countProductsPriceToEuro(List<CurrencyCourse> currencies, List<Product> products) {
        List<Product> currenciesChangedForProds = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            String tempCurr = products.get(i).getCurrency();
            for (int j = 0; j < currencies.size(); j++) {
                if (currencies.get(j).getName().equals(tempCurr)) {
                    BigDecimal priceInEuro = (products.get(i).getPrice()).divide((currencies.get(j).getCourse()), 5);
                    currenciesChangedForProds.add(new Product(products.get(i).getName(), priceInEuro, "EUR"));
                }
            }
        }
        return currenciesChangedForProds;
    }

    public static void showStatistics(List<CurrencyCourse> currencies, List<Product> products) {
        List<Product> currenciesChangedForProds = countProductsPriceToEuro(currencies, products);
        System.out.println("Suma wszystkich produktów w EUR: " + countProductsSum(currenciesChangedForProds) + " EUR");
        System.out.println("Średnia wartość produktu w EUR: " + countAvgPrice(currenciesChangedForProds) + " EUR");
        System.out.println("Nazwa i cena najdroższego produktu (cena w przeliczeniu na EUR): " +
                countMaxPrice(currenciesChangedForProds).getName() + ": " + countMaxPrice(currenciesChangedForProds).getPrice() + " EUR");
        System.out.println("Nazwa i cena najtańszego produktu (cena w przeliczeniu na EUR): " +
                countMinPrice(currenciesChangedForProds).getName() + ": " + countMinPrice(currenciesChangedForProds).getPrice() + " EUR");
    }

    private static BigDecimal countProductsSum(List<Product> products) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Product product : products) {
            sum = sum.add(product.getPrice());
        }
        return sum;
    }

    private static Product countMaxPrice(List<Product> products) {
        BigDecimal max = BigDecimal.ZERO;
        String name = null;
        for (Product product : products) {
            if (product.getPrice().compareTo(max) > 0) {
                max = product.getPrice();
                name = product.getName();
            }
        }
        return new Product(name, max, " EUR");
    }

    private static Product countMinPrice(List<Product> products) {
        BigDecimal min = new BigDecimal(Integer.MAX_VALUE);
        String name = null;
        for (Product product : products) {
            if (product.getPrice().compareTo(min) < 0) {
                min = product.getPrice();
                name = product.getName();
            }
        }
        return new Product(name, min, " EUR");
    }

    private static BigDecimal countAvgPrice(List<Product> products) {
        BigDecimal avgPrice = countProductsSum(products).divide(BigDecimal.valueOf(products.size()));
        return avgPrice;
    }

}

