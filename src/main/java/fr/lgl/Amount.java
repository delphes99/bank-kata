package fr.lgl;

import java.math.BigDecimal;
import java.util.Objects;

public class Amount {
    public static final Amount ZERO = new Amount(BigDecimal.ZERO);

    public static Amount of(double value) {
        return new Amount(new BigDecimal(value));
    }

    private BigDecimal bigDecimal;

    private Amount(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public Amount add(Amount amount) {
        return new Amount(bigDecimal.add(amount.bigDecimal));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Objects.equals(bigDecimal, amount.bigDecimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bigDecimal);
    }
}
