package core.order;

import core.account.Account;
import postgres.base.DataBase;
import postgres.order.Order;

import java.util.List;

public class CloseOrder implements Order {
    private final long id;
    private final String name;

    public CloseOrder(String name, List<String> data) {
        this.name = name;
        this.id = Long.parseLong(data.get(0));
    }

    @Override
    public String toString() {
        return String.format("%s id: %d ", name, id);
    }

    @Override
    public void update(DataBase db) throws IllegalArgumentException {
        Account account = db.get(id);
        if (account == null) {
            throw new IllegalArgumentException();
        }
        db.remove(account);
    }
}
