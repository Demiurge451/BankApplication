package core.console;

import postgres.base.DataBase;
import utils.Writer;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


public class Application {
    public static void main(String[] args) {
        Writer wr = new Writer(new PrintWriter(System.out));
        DataBase db = new DataBase();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        while (!s.equals("end")) {
            parse(db, s, wr);
            s = in.nextLine();
        }
        wr.print(db.getLogs());
        wr.close();
    }

    public static void parse(DataBase db, String s, Writer wr) {
        try {
            db.parse(s);
        } catch (IllegalArgumentException e) {
            wr.print("illegal command or argument");
            wr.flush();
        }
    }
}
