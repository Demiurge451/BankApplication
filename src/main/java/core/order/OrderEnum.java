package core.order;

import postgres.order.Order;

public enum OrderEnum {
    CHECK("check", CheckOrder.class),
    CLOSE("close", CloseOrder.class),
    GET("get", GetOrder.class),
    OPEN("open", OpenOrder.class),
    PUT("put", PutOrder.class),
    SHOW("show", ShowOrder.class),
    TRANSFER("transfer", TransferOrder.class);
    private final String name;
    private final Class<? extends Order> orderClass;
    OrderEnum(String name, Class<? extends Order> orderClass) {
        this.name = name;
        this.orderClass = orderClass;
    }

    public String getName() {
        return name;
    }

    public Class<? extends Order> getOrderClass() {
        return orderClass;
    }
}
