package core.history;

import core.Account;
import core.Operation;
import core.OperationFactory;

public class InformationFactory {
    private final OperationFactory opFactory = new OperationFactory();
    public Information createInf(String operation, String data, long id) {
        Operation op = opFactory.createOperation(operation);
        Information inf;
        //TODO add transfer realization
        if (op.ordinal() <= 3) {
            inf = new BalanceActionInf(op, Long.parseLong(data));
        } else {
            inf = new AccountActionInf(op, new Account(data, id));
        }
        return inf;
    }
}
