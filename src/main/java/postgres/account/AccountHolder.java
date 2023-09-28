package postgres.account;

import java.util.Set;

public interface AccountHolder {
    String getName();
    void add(Account account);
    Set<Account> getAccounts();
}
