package fr.lgl.history;

import fr.lgl.Account;
import fr.lgl.Amount;
import fr.lgl.Transaction;
import org.junit.Test;

import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;

public class HistoryTest {
    @Test
    public void one_deposit() {
        var account = new Account(Amount.of(200.0), of(2018, 1, 1));
        assertThat(HistoryLine.getLines(account)).containsExactly(
                new HistoryLine(Transaction.Type.DEPOSIT, of(2018, 1, 1), Amount.of(200.0), Amount.of(200.0))
        );
    }

    @Test
    public void two_deposits() {
        var account = new Account(  Amount.of(200.0), of(2018, 1, 1));
        account.deposit(            Amount.of(100.0), of(2018, 1, 2));
        assertThat(HistoryLine.getLines(account)).containsExactly(
                new HistoryLine(Transaction.Type.DEPOSIT, of(2018, 1, 1), Amount.of(200.0), Amount.of(200.0)),
                new HistoryLine(Transaction.Type.DEPOSIT, of(2018, 1, 2), Amount.of(100.0), Amount.of(300.0))
        );
    }

    @Test
    public void deposits_and_withdrawals() {
        var account = new Account(  Amount.of(200.0), of(2018, 1, 1));
        account.withdrawal(         Amount.of(100.0), of(2018, 1, 2));
        account.deposit(            Amount.of(100.0), of(2018, 1, 3));
        account.withdrawal(         Amount.of(50.0),  of(2018, 1, 4));
        assertThat(HistoryLine.getLines(account)).containsExactly(
                new HistoryLine(Transaction.Type.DEPOSIT,    of(2018, 1, 1), Amount.of(200.0), Amount.of(200.0)),
                new HistoryLine(Transaction.Type.WITHDRAWAL, of(2018, 1, 2), Amount.of(100.0), Amount.of(100.0)),
                new HistoryLine(Transaction.Type.DEPOSIT,    of(2018, 1, 3), Amount.of(100.0), Amount.of(200.0)),
                new HistoryLine(Transaction.Type.WITHDRAWAL, of(2018, 1, 4), Amount.of(50.0),  Amount.of(150.0))
        );
    }
}