package postgres.order;

import core.account.Account;
import core.history.Logs;

import java.util.List;

public interface Order {
    void update(List<Account> accounts, Logs logs) throws IllegalArgumentException;
    void execute(Account account);
}
