package core.history;

import core.Account;
import core.Operation;

public class AccountActionInf extends Information {
    Operation op;
    Account account;

    public AccountActionInf(Operation op, Account account) {
        super(op);
        this.op = op;
        this.account = account;
    }

    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), account.toString());
    }
}
