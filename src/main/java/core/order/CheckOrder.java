package core.order;

import postgres.account.Account;
import postgres.base.DataBase;
import postgres.order.Order;

import java.util.List;

public class CheckOrder implements Order {
    private final long id;
    private long sum;
    private final String name;
    public CheckOrder(String name, List<String> data) {
        this.name = name;
        this.id = Long.parseLong(data.get(0));
    }

    @Override
    public void update(DataBase db) throws IllegalArgumentException {
        Account account = db.get(id);
        if (account == null) {
            throw new IllegalArgumentException();
        }
        this.sum = account.getBalance();
    }

    @Override
    public String toString() {
        return String.format("%s id: %d sum: %d ", name, id, sum);
    }
}
