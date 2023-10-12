package postgres.account;

public interface Account {
    AccountHolder getHolder();
    long getId();
    long getBalance();
    void setBalance(long balance);
}
