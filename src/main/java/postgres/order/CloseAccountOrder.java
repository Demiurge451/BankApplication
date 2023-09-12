package postgres.order;

import core.Account;
import core.history.Logs;
import postgres.Base;

import java.util.List;

public class CloseAccountOrder implements Order{
    private long id;
    private final String name;
    private Account deleteAccount;

    public CloseAccountOrder(String name, List<String> data) {
        this.name = name;
        this.id = Long.parseLong(data.get(0));
    }

    @Override
    public String toString() {
        return String.format("%s id: %d ", name, id);
    }

    @Override
    public void update(List<Account> accounts, Logs logs) {
        for (Account ac: accounts) {
            if (ac.getId() == id) {
                execute(ac);
            }
        }
        accounts.remove(deleteAccount);
        logs.update(this);
    }

    @Override
    public void execute(Account account) {
        deleteAccount = account;
    }
}
