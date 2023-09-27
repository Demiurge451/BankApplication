package core.account;


import java.util.Objects;

public class Account {
    private final long id;
    private long balance;
    private final AccountHolder holder;

    public Account(long id, String holder) {
        this.holder = new AccountHolder(holder);
        this.id = id;
    }
    public Account(String holder, String balance, long id) {
        this.balance = Long.parseLong(balance);
        this.holder = new AccountHolder(holder);
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
        Account account = (Account) o;
        return id == account.id;
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
