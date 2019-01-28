package fr.lgl;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final List<Transaction> transactions;

    public Account(Amount initialDeposit) {
        transactions = new ArrayList<>();
        transactions.add(new Transaction(initialDeposit));
    }

    public Amount getBalance() {
        return transactions.stream().map(Transaction::getAmount).reduce(Amount.ZERO, Amount::add);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
