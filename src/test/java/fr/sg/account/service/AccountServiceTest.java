package fr.sg.account.service;

import fr.sg.account.domain.Account;
import fr.sg.account.domain.Operation;
import fr.sg.account.domain.Type;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountServiceTest {
    @InjectMocks
    AccountService accountService = new AccountService();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeposit() {
        Date date = new Date();
        Account account = new Account(1L, date, new ArrayList<>());
        Long balance = accountService.deposit(account, 2L, date);
        assertThat(balance).isEqualTo(3L);
    }

    @Test
    public void testWithdraw() {
        Date date = new Date();
        Account account = new Account(3L, date, new ArrayList<>());
        Long balance = accountService.withdraw(account, 2L, date);
        assertThat(balance).isEqualTo(1L);
    }

    @Test
    public void testOperationsTypeKo() {
        Date date = new Date();
        Account account = new Account(0L, date, new ArrayList<>());
        accountService.deposit(account, 2L, date);
        assertThat(account.getOperations()).isNotEqualTo(Collections.singletonList(
                new Operation(Type.WITHDRAW, date, 2L)
        ));
    }

    @Test
    public void testOperationsAmountKo() {
        Date date = new Date();
        Account account = new Account(0L, date, new ArrayList<>());
        accountService.deposit(account, 2L, date);
        assertThat(account.getOperations()).isNotEqualTo(Collections.singletonList(
                new Operation(Type.DEPOSIT, date, 3L)
        ));
    }

    @Test
    public void testOperations() {
        Date date = new Date();
        Account account = new Account(0L, date, new ArrayList<>());
        accountService.deposit(account, 2L, date);
        accountService.deposit(account, 3L, date);
        accountService.withdraw(account, 1L, date);
        assertThat(account.getOperations()).isEqualTo(asList(
                new Operation(Type.DEPOSIT, date, 2L),
                new Operation(Type.DEPOSIT, date, 3L),
                new Operation(Type.WITHDRAW, date, 1L)
        ));
    }
}