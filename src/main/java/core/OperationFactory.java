package core;

public class OperationFactory {
    public Operation createOperation(String command) {
        for(Operation op: Operation.values()) {
            if (op.toString().equals(command)) {
                return op;
            }
        }
        //TODO add exception
        return null;
    }
}
