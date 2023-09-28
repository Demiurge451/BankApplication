package core.order;

import postgres.account.Account;
import postgres.base.DataBase;
import postgres.order.Order;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class GetOrder implements Order {
    private final long id;
    private final long sum;
    private final String name;

    public GetOrder(String name, List<String> data) {
        this.name = name;
        this.id = Long.parseLong(data.get(0));
        this.sum = Long.parseLong(data.get(1));
    }

    public GetOrder(Account ac, long sum) {
        this.name = Objects.requireNonNull(Stream.of(OrderEnum.values())
                .filter(en -> en.getOrderClass() == this.getClass())
                .findAny().orElse(null)).getName();
        this.id = ac.getId();
        this.sum = sum;
    }


    @Override
    public String toString() {
        return String.format("%s id: %d sum: %d ", name, id, sum);
    }

    @Override
    public void update(DataBase db) throws IllegalArgumentException{
        Account account = db.get(id);
        if (account != null && account.getBalance() >= sum) {
            account.setBalance(account.getBalance() - sum);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
