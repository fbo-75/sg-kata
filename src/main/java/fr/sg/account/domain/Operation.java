package fr.sg.account.domain;

import java.util.Date;
import java.util.Objects;

/**
 * @author fares.boulmali
 */
public class Operation {
    private final Type type;
    private final Date date;
    private final Long amount;

    public Operation(Type type, Date date, Long amount) {
        this.type = type;
        this.date = date;
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, date, amount);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Operation operation = (Operation) o;
        return type.equals(operation.type) && date.equals(operation.date) && amount.equals(operation.amount);
    }

}
