package pl.javastart.task;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    String name;
    BigDecimal price;
    String currency;

    public Product(String name, BigDecimal price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product product)) {
            return false;
        }
        return Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(currency, product.currency);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}
