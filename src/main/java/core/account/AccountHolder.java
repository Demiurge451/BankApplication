package core.account;

import java.util.HashSet;
import java.util.Set;

public class AccountHolder {
    private final String name;

    private Set<Account> accounts = new HashSet<>();

    public AccountHolder(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
