package postgres.order;

import java.util.List;
import java.util.Map;

public class OrderFactory {
    private final Map<String, Class<? extends Order>> orders = Map.of(
            "get", GetOrder.class,
            "put", PutOrder.class, "check", CheckOrder.class,
            "transfer", TransferOrder.class,
            "open_account", OpenAccountOrder.class,
            "close_account", CloseAccountOrder.class);


    public Order createOrder(String order, List<String> data) {
        //TODO add exception and explain why data.getClass doesn't work
        Class<? extends Order> cls = orders.get(order);
        try {
            return cls.getConstructor(new Class[]{order.getClass(), List.class}).newInstance(order, data);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
