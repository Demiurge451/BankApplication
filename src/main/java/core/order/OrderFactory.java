package core.order;

import postgres.order.Order;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class OrderFactory {

    public Order createOrder(String order, List<String> data) throws IllegalArgumentException{
        try {
            Class<? extends Order> cls = Objects.requireNonNull(Stream.of(OrderEnum.values())
                    .filter(en -> en.getName().equals(order))
                    .findAny().orElse(null)).getOrderClass();
            return Objects.requireNonNull(cls).getConstructor(new Class[]{order.getClass(), List.class}).newInstance(order, data);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
