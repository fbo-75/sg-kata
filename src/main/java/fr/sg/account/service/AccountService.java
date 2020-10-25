package fr.sg.account.service;

import fr.sg.account.domain.Account;
import fr.sg.account.domain.Operation;
import fr.sg.account.domain.Type;

import java.util.Date;

/**
 * @author fares.boulmali
 */
public class AccountService {

    public AccountService() {
    }

    public Long deposit(Account account, final long amount, Date depositDate) {
        final Operation operation = new Operation(Type.DEPOSIT, depositDate, amount);
        account.getOperations().add(operation);
        return account.getBalance() + amount;
    }

    public Long withdraw(Account account, final long amount, Date depositDate) {
        final Operation operation = new Operation(Type.WITHDRAW, depositDate, amount);
        account.getOperations().add(operation);
        return account.getBalance() - amount;
    }

}
