package core.order;

import core.account.Account;
import postgres.base.DataBase;
import postgres.order.Order;

import java.util.List;

public class TransferOrder implements Order {
    private final long id1;
    private final long id2;
    private final long sum;
    private final String name;

    public TransferOrder(String name, List<String> data) {
        this.name = name;
        this.id1 = Long.parseLong(data.get(0));
        this.id2 = Long.parseLong(data.get(1));
        this.sum = Long.parseLong(data.get(2));
    }


    @Override
    public String toString() {
        return String.format("%s from id: %d to id: %d sum: %d ", name, id1, id2, sum);
    }

    @Override
    public void update(DataBase db) throws IllegalArgumentException {
        Account fromAccount = db.get(id1);
        Account toAccount = db.get(id2);
        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException();
        }
        new GetOrder(fromAccount, sum).update(db);
        new PutOrder(toAccount, sum).update(db);
    }
}
