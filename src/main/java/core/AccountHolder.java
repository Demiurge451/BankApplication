package core;

import java.util.HashSet;
import java.util.Set;

public class AccountHolder {
    private final String name;

    private Set<Account> accounts = new HashSet<>();

    public AccountHolder(String name) {
        this.name = name;
    }

    public void openAccount(long id) {
        accounts.add(new Account(this.toString(), id));
    }

    public void closeAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public String toString() {
        return name;
    }
}
