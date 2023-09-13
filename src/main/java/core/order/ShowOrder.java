package core.order;

import core.Account;
import core.history.Logs;
import postgres.order.Order;

import java.util.List;

public class ShowOrder implements Order {
    private final String name;
    private StringBuilder buffer = new StringBuilder();

    public ShowOrder(String name, List<String> data) {
        this.name = name;
    }

    @Override
    public void update(List<Account> accounts, Logs logs) {
        for (Account ac: accounts) {
            execute(ac);
        }
        logs.addToBuffer(buffer.toString());
        logs.update(this);
    }

    @Override
    public void execute(Account account) {
        buffer.append(account.toString()).append("\n");
    }

    @Override
    public String toString() {
        return name;
    }
}
