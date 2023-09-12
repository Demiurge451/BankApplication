package core;


import java.util.Objects;

public class Account {
    private final long id;
    private long balance;
    private final AccountHolder holder;

    public Account(String holder, long id) {
        this.holder = new AccountHolder(holder);
        this.id = id;
    }
    public Account(String holder, String balance, long id) {
        this.balance = Long.parseLong(balance);
        this.holder = new AccountHolder(holder);
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void putMoney(long sum) {
        balance += sum;
    }

    //TODO add exception
    public void getMoney(long sum) {
        balance -= sum;
    }

    //TODO add exception
    public void transfer(Account to, long sum) {
        this.getMoney(sum);
        to.putMoney(sum);
    }

    @Override
    public String toString() {
        return String.format("core.Account id: %d core.Account holder: %s ", id, holder.toString());
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
}
