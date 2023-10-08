package pl.javastart.task;

import java.math.BigDecimal;
import java.util.Objects;

public class CurrencyCourse {
    String name;
    BigDecimal course;

    public CurrencyCourse(String name, BigDecimal course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CurrencyCourse that)) {
            return false;
        }
        return Objects.equals(name, that.name) && Objects.equals(course, that.course);
    }

    @Override
    public String toString() {
        return "CurrencyCourse{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
