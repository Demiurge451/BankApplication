package core.order;

import core.account.AccountImpl;
import postgres.base.DataBase;
import postgres.order.Order;

import java.util.List;

public class OpenOrder implements Order {
    private long id;
    private final String name;
    private String holder;
    public OpenOrder(String name, List<String> data) {
        this.name = name;
        this.holder = data.get(0);
    }

    public OpenOrder(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s id: %d holder: %s ", name, id, holder);
    }

    @Override
    public void update(DataBase db) {
        id = db.getGlobalId();
        db.put(new AccountImpl(id, holder));
    }
}
