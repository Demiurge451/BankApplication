package core.order;

import postgres.base.DataBase;
import postgres.order.Order;
import java.util.List;

public class ShowOrder implements Order {
    private final String name;

    public ShowOrder(String name, List<String> data) {
        this.name = name;
    }

    @Override
    public void update(DataBase db) {
        db.showAccounts();
    }

    @Override
    public String toString() {
        return name;
    }
}
