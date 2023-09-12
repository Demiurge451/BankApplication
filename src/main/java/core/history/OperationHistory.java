package core.history;


import core.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationHistory {
    private long globalId;
    private final InformationFactory infFactory = new InformationFactory();
    List<Information> history = new ArrayList<>();

    public void update(String op, String data) {
        Information inf = infFactory.createInf(op, data, globalId);
        if (inf.getOp() == Operation.OPEN_ACCOUNT) {
            globalId++;
        }
        history.add(inf);
    }

    public String showHistory() {
        StringBuilder data = new StringBuilder();
        for (Information inf: history) {
            data.append(inf.toString()).append("\n");
        }
        return data.toString();
    }
}
