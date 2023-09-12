package postgres.order;

import core.Account;
import core.history.Logs;
import postgres.Base;

import java.util.ArrayList;
import java.util.List;

public class TransferOrder implements Order{
    private long id1;
    private long id2;
    private Account fromAccount;
    private long sum;
    private String name;

    public TransferOrder(String name, List<String> data) {
        this.name = name;
        this.id1 = Long.parseLong(data.get(0));
        this.id2 = Long.parseLong(data.get(1));
        this.sum = Long.parseLong(data.get(2));
    }


    @Override
    public String toString() {
        return String.format("%s from id: %d to id: %d sum: %d ", name, id1, id2, sum);
    }

    @Override
    public void update(List<Account> accounts, Logs logs) {
        Account toAccount = null;
        for (Account ac: accounts) {
            if (ac.getId() == id1) {
                fromAccount = ac;
            }
            if (ac.getId() == id2) {
                toAccount = ac;
            }
        }
        execute(toAccount);
        logs.update(this);
    }

    @Override
    public void execute(Account toAccount) {
        new GetOrder(fromAccount, sum);
        new PutOrder(toAccount, sum);
    }
}
