package postgres.order;

import core.Account;
import core.history.Logs;
import postgres.Base;

import java.util.List;

public class GetOrder implements Order{
    private long id;
    private long sum;
    private final String name;

    public GetOrder(String name, List<String> data) {
        this.name = name;
        this.id = Long.parseLong(data.get(0));
        this.sum = Long.parseLong(data.get(1));
    }

    public GetOrder(Account ac, long sum) {
        this.name = "get";
        this.id = ac.getId();
        this.sum = sum;
    }


    @Override
    public String toString() {
        return String.format("%s id: %d sum: %d ", name, id, sum);
    }

    @Override
    public void update(List<Account> accounts, Logs logs) {
        for (Account ac: accounts) {
            if (ac.getId() == id) {
                execute(ac);
            }
        }
        logs.update(this);
    }

    @Override
    public void execute(Account account) {
        //TODO add exception
        if (account.getBalance() >= sum) {
            account.setBalance(account.getBalance() - sum);
        }
    }
}
