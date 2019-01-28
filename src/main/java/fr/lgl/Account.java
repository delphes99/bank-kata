package fr.lgl;

import java.math.BigDecimal;

public class Account {
    private BigDecimal initialDeposit;

    public Account() {
        this.initialDeposit = BigDecimal.ZERO;
    }

    public Account(BigDecimal initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    public BigDecimal getBalance() {
        return initialDeposit;
    }
}