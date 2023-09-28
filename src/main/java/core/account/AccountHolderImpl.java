package core.account;

import postgres.account.Account;
import postgres.account.AccountHolder;

import java.util.HashSet;
import java.util.Set;

public class AccountHolderImpl implements AccountHolder {
    private final String name;

    private final Set<Account> accounts = new HashSet<>();

    public AccountHolderImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Account account) {
        accounts.add(account);
    }

    @Override
    public String toString() {
        return name;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }
}
