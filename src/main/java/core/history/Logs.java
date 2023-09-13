package core.history;


import postgres.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Logs {
    private int globalId;
    private List<Information> history = new ArrayList<>();
    private List<String> buffer = new ArrayList<>();
    public void update(Order order) {
        Information inf = new Information(order);
        globalId++;
        history.add(inf);
    }

    public String showLogs() {
        StringBuilder data = new StringBuilder();
        for (Information inf: history) {
            data.append(inf.toString()).append("\n");
        }
        return data.toString();
    }

    public int getGlobalId() {
        return globalId;
    }

    public List<String> getBuffer() {
        return buffer;
    }

    public void addToBuffer(String s) {
        buffer.add(s);
    }
}
