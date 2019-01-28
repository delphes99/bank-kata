package fr.lgl;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    public enum Type {
        DEPOSIT(Amount.of(1)),
        WITHDRAWAL(Amount.of(-1));

        private Amount multiplier;

        Type(Amount multiplier) {
            this.multiplier = multiplier;
        }
    }

    private final Amount amount;
    private final Type type;
    private final LocalDate date;

    public Transaction(Amount amount, Type type, LocalDate date) {
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public Amount getSignedAmount() {
        return amount.multiply(type.multiplier);
    }

    public Amount getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(amount, that.amount) &&
                type == that.type &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, type, date);
    }
}
