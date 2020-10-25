package fr.sg.account.domain;

import java.util.Date;
import java.util.List;

/**
 * @author fares.boulmali
 */
public class Account {
    private Long balance;
    private Date date;
    private List<Operation> operations;

    public Account(Long balance, Date date, List<Operation> operations) {
        this.balance = balance;
        this.date = date;
        this.operations = operations;
    }

    public long getBalance() {
        return balance;
    }

    public Date getDate() {
        return date;
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
