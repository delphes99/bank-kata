package fr.lgl.history;

import fr.lgl.Account;
import fr.lgl.Amount;
import fr.lgl.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class HistoryLine {
    private final Transaction.Type deposit;
    private final LocalDate date;
    private final Amount transactionAmount;
    private final Amount balance;

    HistoryLine(Transaction.Type deposit, LocalDate date, Amount transactionAmount, Amount balance) {
        this.deposit = deposit;
        this.date = date;
        this.transactionAmount = transactionAmount;
        this.balance = balance;
    }

    public static List<HistoryLine> getLines(Account account) {
        var historyLines = new ArrayList<HistoryLine>();

        Amount balance = Amount.ZERO;
        for (Transaction transaction : account.getTransactions()) {
            balance = balance.add(transaction.getSignedAmount());
            historyLines.add(new HistoryLine(transaction.getType(), transaction.getDate(), transaction.getAmount(), balance));
        }

        return historyLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryLine that = (HistoryLine) o;
        return deposit == that.deposit &&
                Objects.equals(date, that.date) &&
                Objects.equals(transactionAmount, that.transactionAmount) &&
                Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deposit, date, transactionAmount, balance);
    }
}
