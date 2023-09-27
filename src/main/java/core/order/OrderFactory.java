package core.order;

import postgres.order.Order;

import java.util.List;
import java.util.Map;

public class OrderFactory {
    private final Map<String, Class<? extends Order>> orders = Map.of(
            "get", GetOrder.class,
            "put", PutOrder.class, "check", CheckOrder.class,
            "transfer", TransferOrder.class,
            "open", OpenOrder.class,
            "close", CloseOrder.class,
            "show", ShowOrder.class);


    public Order createOrder(String order, List<String> data) throws IllegalArgumentException{
        Class<? extends Order> cls = orders.get(order);
        try {
            return cls.getConstructor(new Class[]{order.getClass(), List.class}).newInstance(order, data);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
