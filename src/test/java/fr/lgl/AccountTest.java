package fr.lgl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.math.BigDecimal;

public class AccountTest {
    @Test
    public void account_created_with_empty_balance() {
        assertThat(new Account().getBalance()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void account_created_with_initial_deposit() {
        var account = new Account(BigDecimal.valueOf(200.0));
        assertThat(account.getBalance()).isEqualTo(BigDecimal.valueOf(200.0));
    }
}
