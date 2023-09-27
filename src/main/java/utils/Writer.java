package utils;

import java.io.PrintWriter;
import java.util.List;

public class Writer {
    private PrintWriter out;

    public Writer(PrintWriter out) {
        this.out = out;
    }

    public void print(List<?> arr) {
        for (Object el: arr) {
            out.println(el);
        }
        out.close();
    }
}
