package postgres;

import core.Account;
import core.history.OperationHistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Base {
    private List<Account> accountsBase = new ArrayList<>();
    private static OperationHistory history = new OperationHistory();

    public Base() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //TODO add Exception
        String s = in.nextLine();
        while (!s.equals("end")) {
            List<String> list = Arrays.asList(s.split("\\s+"));
            history.update(list.get(0), list.get(1));
            s = in.nextLine();
        }
        System.out.println(history.showHistory());
    }
}
