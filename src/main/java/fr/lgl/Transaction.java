package fr.lgl;

import java.util.Objects;

public class Transaction {
    private Amount amount;

    public Transaction(Amount amount) {
        this.amount = amount;
    }

    public Amount getAmount() {
        return this.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
