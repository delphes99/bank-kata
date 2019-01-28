package fr.lgl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AccountTest {
    @Test
    public void account_created_with_initial_deposit() {
        var account = new Account(Amount.of(200.0));
        assertThat(account.getBalance()).isEqualTo(Amount.of(200.0));
    }

    @Test
    public void initial_deposit_create_transaction() {
        var account = new Account(Amount.of(200.0));
        assertThat(account.getTransactions())
                .containsExactly(
                        new Transaction(Amount.of(200.0))
                );
    }

    @Test
    public void deposit_create_transaction() {
        var account = new Account(Amount.of(200.0));
        account.deposit(Amount.of(300.0));
        assertThat(account.getTransactions())
                .containsExactly(
                        new Transaction(Amount.of(200.0)),
                        new Transaction(Amount.of(300.0))
                );
    }
}
