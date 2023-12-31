package core.account;

import postgres.account.Information;
import postgres.order.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InformationImpl implements Information {
    private final Date date;
    private final Order order;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
    public InformationImpl(Order order) {
        this.order = order;
        this.date = new Date(System.currentTimeMillis());
    }
    public String toString(){
        return String.format("%s %s", formatter.format(date) , order.toString());
    }

    public Order getOrder() {
        return order;
    }
}
