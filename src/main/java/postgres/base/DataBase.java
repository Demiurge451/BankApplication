package postgres.base;

import core.account.AccountHolderImpl;
import core.account.Information;
import postgres.account.Account;
import postgres.account.AccountHolder;
import postgres.order.Order;
import core.order.OrderFactory;

import java.util.*;

public class DataBase {
    private long globalId;
    private final List<Account> accounts = new ArrayList<>();
    private final List<Information> logs = new ArrayList<>();
    private final List<AccountHolder> accountHolders = new ArrayList<>();
    private final OrderFactory orderFactory = new OrderFactory();

    public void update(Order or) {
        logs.add(new Information(or));
        or.update(this);
        globalId++;
    }


    public void parse(String s) {
        List<String> list = Arrays.asList(s.split("\\s+"));
        Order or = orderFactory.createOrder(list.get(0), list.subList(1, list.size()));
        this.update(or);
    }

    public List<String> getLogs() {
        List<String> list = new ArrayList<>();
        for (Information inf: logs) {
            list.add(inf.toString());
        }
        return list;
    }

    public Account get(long id) throws NullPointerException{
        return accounts.stream().filter(ac -> ac.getId() == id)
                .findAny().orElse(null);
    }

    public AccountHolder get(String name) throws NullPointerException{
        return accountHolders.stream().filter(hol -> hol.getName().equals(name))
                .findAny().orElse(null);
    }

    public void put(Account account) {
        AccountHolder h = get(account.getHolder().getName());
        if (h != null) {
            h.add(account);
        } else {
            accountHolders.add(new AccountHolderImpl(account.getHolder().getName()));
        }
        accounts.add(account);
    }

    public void remove(Account account) {
        accounts.remove(account);
    }

    public long getGlobalId() {
        return globalId;
    }

    public void showAccounts() {
        // TODO refactor
        for (Account ac: accounts) {
            System.out.println(ac);
        }
    }
}
