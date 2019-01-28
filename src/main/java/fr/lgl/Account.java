package fr.lgl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static fr.lgl.Transaction.Type.DEPOSIT;
import static fr.lgl.Transaction.Type.WITHDRAWAL;

public class Account {
    private final List<Transaction> transactions;

    public Account(Amount initialDeposit, LocalDate date) {
        transactions = new ArrayList<>();
        deposit(initialDeposit, date);
    }

    public Amount getBalance() {
        return transactions.stream().map(Transaction::getSignedAmount).reduce(Amount.ZERO, Amount::add);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(Amount amount, LocalDate date) {
        createTransaction(amount, date, DEPOSIT);
    }

    public void withdrawal(Amount amount, LocalDate date) {
        createTransaction(amount, date, WITHDRAWAL);
    }

    private void createTransaction(Amount amount, LocalDate date, Transaction.Type type) {
        transactions.add(new Transaction(amount, type, date));
    }
}
