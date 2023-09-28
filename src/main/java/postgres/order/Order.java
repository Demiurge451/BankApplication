package postgres.order;

import postgres.base.DataBase;

public interface Order {
    void update(DataBase db) throws IllegalArgumentException;
}
