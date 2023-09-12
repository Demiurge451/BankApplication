package core;

public enum Operation {
    GET_MONEY("get_money"),
    PUT_MONEY("put_money"),
    TRANSFER("transfer"),
    GET_BALANCE("get_balance"),
    OPEN_ACCOUNT("open_account"),
    CLOSE_ACCOUNT("close_account");

    private final String command;

    Operation(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command;
    }
}
