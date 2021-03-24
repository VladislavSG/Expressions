package expression.exceptions.EvaluatingExceptions;

/**
 * @author Vladislav Gusev (vladislav.sg@yandex.ru)
 */
public class IllegalOperationException extends EvaluateException {
    public IllegalOperationException(String op) {
        super("Operation " + op + " is not allowed");
    }

    public IllegalOperationException() {
        super("Operation is not allowed");
    }
}
