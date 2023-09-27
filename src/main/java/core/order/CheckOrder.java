package core.order;

import core.account.Account;
import core.history.Logs;
import postgres.order.Order;

import java.util.List;

public class CheckOrder implements Order {
    private long id;
    private long sum;
    private final String name;
    public CheckOrder(String name, List<String> data) {
        this.name = name;
        this.id = Long.parseLong(data.get(0));
    }

    @Override
    public void update(List<Account> accounts, Logs logs) throws IllegalArgumentException {
        for (Account ac: accounts) {
            if (ac.getId() == id) {
                execute(ac);
            }
        }
            logs.update(this);
    }

    @Override
    public void execute(Account account) {
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
