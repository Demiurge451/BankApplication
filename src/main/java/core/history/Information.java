package core.history;

import core.Operation;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Information {
    private final Date date;
    private final Operation op;
    private final SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
    protected Information(Operation op) {
        this.op = op;
        this.date = new Date(System.currentTimeMillis());
    }
    public String toString(){
        return String.format("%s %s", formatter.format(date) , op.toString());
    }

    public Operation getOp() {
        return op;
    }
}
