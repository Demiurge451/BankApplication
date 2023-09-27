package postgres.base;

import core.account.Account;
import core.history.Logs;
import postgres.order.Order;
import core.order.OrderFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataBase {
    private List<Account> accounts = new ArrayList<>();
    private Logs logs = new Logs();
    private final OrderFactory orderFactory = new OrderFactory();

    public void update(Order or) {
        or.update(accounts, logs);
    }

    public void parse(String s) {
        List<String> list = Arrays.asList(s.split("\\s+"));
        Order or = orderFactory.createOrder(list.get(0), list.subList(1, list.size()));
        this.update(or);
    }

    public String showBuffer() {
        StringBuilder sb = new StringBuilder();
        for (String s: logs.getBuffer()) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }

    public String showLogs() {
        return logs.showLogs();
    }

    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        Scanner in = new Scanner(System.in);
        //TODO add Exception
        String s = in.nextLine();
        while (!s.equals("end")) {
            dataBase.parse(s);
            if (!dataBase.showBuffer().equals("")) {
                System.out.print(dataBase.showBuffer());
            }
            s = in.nextLine();
        }

        System.out.print(dataBase.showLogs());
    }
}
