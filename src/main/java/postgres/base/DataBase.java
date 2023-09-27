package postgres.base;

import core.account.Account;
import core.account.AccountHolder;
import core.history.Information;
import postgres.order.Order;
import core.order.OrderFactory;
import utils.Writer;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    public Account get(long id) {
        for (Account account: accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        //TODO add exception
        return null;
    }

    public AccountHolder get(String name) {
        for (AccountHolder h: accountHolders) {
            if (h.getName().equals(name)) {
                return h;
            }
        }
        //TODO add exception
        return null;
    }

    public void put(Account account) {
        AccountHolder h = get(account.getHolder().getName());
        if (h != null) {
            h.add(account);
        } else {
            accountHolders.add(new AccountHolder(account.getHolder().getName()));
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
        for (Account ac: accounts) {
            System.out.println(ac);
        }
    }

    public static void main(String[] args) {
        Writer wr = new Writer(new PrintWriter(System.out));
        DataBase db = new DataBase();
        Scanner in = new Scanner(System.in);
        //TODO add Exception
        String s = in.nextLine();
        while (!s.equals("end")) {
            db.parse(s);
            s = in.nextLine();
        }

        wr.print(db.getLogs());
    }
}
