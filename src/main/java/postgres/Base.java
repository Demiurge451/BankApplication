package postgres;

import core.Account;
import core.history.Logs;
import postgres.order.CheckOrder;
import postgres.order.Order;
import postgres.order.OrderFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Base {
    private List<Account> accounts = new ArrayList<>();
    private Logs logs = new Logs();
    private final OrderFactory orderFactory = new OrderFactory();

    public Base() {

    }

    public void update(Order or) {
        or.update(accounts, logs);
    }

    public void parse(String s) {
        List<String> list = Arrays.asList(s.split("\\s+"));
        Order or = orderFactory.createOrder(list.get(0), list.subList(1, list.size()));
        or.update(accounts, logs);
    }

    public String showLogs() {
        return logs.showLogs();
    }

    public static void main(String[] args) {
        Base base = new Base();
        Scanner in = new Scanner(System.in);
        //TODO add Exception
        String s = in.nextLine();
        while (!s.equals("end")) {
            base.parse(s);
            s = in.nextLine();
        }

        System.out.println(base.showLogs());
    }
}
