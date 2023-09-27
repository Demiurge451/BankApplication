package core.order;

import core.account.Account;
import core.history.Logs;
import postgres.order.Order;

import java.util.List;

public class PutOrder implements Order {
    private long id;
    private long sum;
    private String name;

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
    public void update(List<Account> accounts, Logs logs) throws IllegalArgumentException{
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
        account.setBalance(account.getBalance() + sum);
    }
}
