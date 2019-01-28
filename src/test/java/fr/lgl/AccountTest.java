package fr.lgl;

import static fr.lgl.Transaction.Type.DEPOSIT;
import static fr.lgl.Transaction.Type.WITHDRAWAL;
import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.time.LocalDate;

public class AccountTest {
    @Test
    public void account_created_with_initial_deposit() {
        var account = new Account(Amount.of(200.0), of(2018, 1, 1));
        assertThat(account.getBalance()).isEqualTo(Amount.of(200.0));
    }

    @Test
    public void initial_deposit_create_transaction() {
        var account = new Account(Amount.of(200.0), of(2018, 1, 1));
        assertThat(account.getTransactions())
                .containsExactly(
                        new Transaction(Amount.of(200.0), DEPOSIT, LocalDate.of(2018, 1, 1))
                );
    }

    @Test
    public void deposit_create_transaction() {
        var account = new Account(Amount.of(200.0), of(2018, 1, 1));
        account.deposit(Amount.of(300.0), of(2018, 1, 2));
        assertThat(account.getTransactions())
                .containsExactly(
                        new Transaction(Amount.of(200.0), DEPOSIT, LocalDate.of(2018, 1, 1)),
                        new Transaction(Amount.of(300.0), DEPOSIT, LocalDate.of(2018, 1, 2))
                );
    }

    @Test
    public void withdrawal_create_transaction() {
        var account = new Account(Amount.of(200.0), of(2018, 1, 1));
        account.withdrawal(Amount.of(100.0), of(2018, 1, 2));
        assertThat(account.getTransactions())
                .containsExactly(
                        new Transaction(Amount.of(200.0), DEPOSIT, LocalDate.of(2018, 1, 1)),
                        new Transaction(Amount.of(100.0), WITHDRAWAL, LocalDate.of(2018, 1, 2))
                );
    }
}
