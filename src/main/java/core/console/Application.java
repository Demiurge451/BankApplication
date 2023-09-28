package core.console;

import postgres.base.DataBase;
import utils.Writer;

import java.io.PrintWriter;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Writer wr = new Writer(new PrintWriter(System.out));
        DataBase db = new DataBase();
        Scanner in = new Scanner(System.in);
        //TODO add Exception catcher
        String s = in.nextLine();
        while (!s.equals("end")) {
            db.parse(s);
            s = in.nextLine();
        }

        wr.print(db.getLogs());
    }
}
