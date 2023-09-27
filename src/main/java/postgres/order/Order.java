package postgres.order;

import core.account.Account;
import core.history.Information;
import postgres.base.DataBase;

import java.util.List;

public interface Order {
    void update(DataBase db) throws IllegalArgumentException;
}
