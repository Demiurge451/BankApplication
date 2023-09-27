package core.order;

import core.account.Account;
import core.history.Logs;
import postgres.order.Order;

import java.util.List;

public class CloseOrder implements Order {
    private long id;
    private final String name;
    private Account deleteAccount;

    public CloseOrder(String name, List<String> data) {
        this.name = name;
        this.id = Long.parseLong(data.get(0));
    }

    @Override
    public String toString() {
        return String.format("%s id: %d ", name, id);
    }

    @Override
    public void update(List<Account> accounts, Logs logs) throws IllegalArgumentException {
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
        if (account == null) {
            throw new IllegalArgumentException();
        }
        deleteAccount = account;
    }
}
