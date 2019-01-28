package fr.lgl;

import java.math.BigDecimal;
import java.util.Objects;

public class Amount {
    public static final Amount ZERO = new Amount(BigDecimal.ZERO);

    public static Amount of(double value) {
        return new Amount(new BigDecimal(value));
    }

    private BigDecimal value;

    private Amount(BigDecimal value) {
        this.value = value;
    }

    public Amount add(Amount amount) {
        return new Amount(value.add(amount.value));
    }

    public Amount multiply(Amount multiplier) {
        return new Amount(value.multiply(multiplier.value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Objects.equals(value, amount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
