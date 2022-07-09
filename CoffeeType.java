package machine;

import java.util.NoSuchElementException;
import java.util.Objects;

public enum CoffeeType {
    espresso("1"),
    latte("2"),
    cappuccino("3"),
    exit("back");

    private final String code;

    CoffeeType(String code) {
        this.code = code;
    }

    public static CoffeeType findByCode(String code) {
        for (CoffeeType coffee : values()) {
            if (Objects.equals(coffee.code, code)) {
                return coffee;
            }
        }

        throw new NoSuchElementException(
                "not found type of coffee" + code);
    }
}
