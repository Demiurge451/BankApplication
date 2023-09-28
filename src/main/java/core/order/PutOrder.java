package core.order;

import core.account.Account;
import postgres.base.DataBase;
import postgres.order.Order;

import java.util.List;

public class PutOrder implements Order {
    private final long id;
    private final long sum;
    private final String name;

    public PutOrder(String name, List<String> data) {
        this.name = name;
        this.id = Long.parseLong(data.get(0));
        this.sum = Long.parseLong(data.get(1));
    }

    public PutOrder(Account ac, long sum) {
        this.name = "put";
        this.sum = sum;
        this.id = ac.getId();
    }

    @Override
    public String toString() {
        return String.format("%s id: %d sum: %d ", name, id, sum);
    }

    @Override
    public void update(DataBase db) throws IllegalArgumentException{
        Account account = db.get(id);
        if (account == null) {
            throw new IllegalArgumentException();
        }
        account.setBalance(account.getBalance() + sum);
    }
}
