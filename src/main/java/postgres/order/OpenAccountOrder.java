package postgres.order;

import core.Account;
import core.history.Logs;
import postgres.Base;

import java.util.List;

public class OpenAccountOrder implements Order{
    private long id;
    private final String name;
    private String holder;
    public OpenAccountOrder(String name, List<String> data) {
        this.name = name;
        this.holder = data.get(0);
    }

    public OpenAccountOrder(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return String.format("%s id: %d holder: %s ", name, id, holder);
    }

    @Override
    public void update(List<Account> accounts, Logs logs) {
        this.id = accounts.size();
        accounts.add(new Account(accounts.size(), holder));
        logs.update(this);
    }

    @Override
    public void execute(Account account) {

    }
}
