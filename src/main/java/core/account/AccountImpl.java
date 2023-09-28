package core.account;


import postgres.account.Account;
import postgres.account.AccountHolder;

import java.util.Objects;

public class AccountImpl implements Account {
    private final long id;
    private long balance;
    private final AccountHolder holder;

    public AccountImpl(long id, String holder) {
        this.holder = new AccountHolderImpl(holder);
        this.id = id;
    }
    public AccountImpl(String holder, String balance, long id) {
        this.balance = Long.parseLong(balance);
        this.holder = new AccountHolderImpl(holder);
        this.id = id;
    }


    @Override
    public String toString() {
        return String.format("Account id: %d Account holder: %s ", id, holder.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountImpl accountImp = (AccountImpl) o;
        return id == accountImp.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public AccountHolder getHolder() {
        return holder;
    }

    public long getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
