package postgres.order;

import core.Account;
import core.history.Logs;
import postgres.Base;

import java.util.List;

public interface Order {
    void update(List<Account> accounts, Logs logs);
    void execute(Account account);
}
