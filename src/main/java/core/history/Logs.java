package core.history;


import postgres.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Logs {
    private List<Information> history = new ArrayList<>();
    public void update(Order order) {
        Information inf = new Information(order);
        history.add(inf);
    }

    public String showLogs() {
        StringBuilder data = new StringBuilder();
        for (Information inf: history) {
            data.append(inf.toString()).append("\n");
        }
        return data.toString();
    }
}
