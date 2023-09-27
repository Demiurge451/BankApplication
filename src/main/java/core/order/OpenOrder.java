package core.order;

import core.account.Account;
import core.history.Logs;
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
    public void update(List<Account> accounts, Logs logs) {
        id = logs.getGlobalId();
        accounts.add(new Account(id, holder));
        logs.update(this);
    }

    @Override
    public void execute(Account account) {

    }
}
