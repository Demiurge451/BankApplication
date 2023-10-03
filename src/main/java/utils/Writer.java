package utils;

import java.io.PrintWriter;
import java.util.List;

public class Writer {
    private final PrintWriter out;

    public Writer(PrintWriter out) {
        this.out = out;
    }

    public void print(List<?> arr) {
        arr.forEach(out::println);
    }

    public <T> void print(T o) {
        out.println(o);
    }

    public void close() {
        out.close();
    }

    public void flush() {
        out.flush();
    }
}
