package core.history;

import core.Operation;

public class BalanceActionInf extends Information {
    private final long sum;

    public BalanceActionInf(Operation op, long sum) {
        super(op);
        this.sum = sum;
    }

    @Override
    public String toString() {
        return String.format("%s sum: %d", super.toString(), sum);
    }
}
