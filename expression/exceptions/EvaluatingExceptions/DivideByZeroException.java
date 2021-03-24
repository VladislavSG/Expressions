package expression.exceptions.EvaluatingExceptions;

public class DivideByZeroException extends EvaluateException {
    public DivideByZeroException(String message) {
        super(message);
    }

    public DivideByZeroException() {
        super("Division by zero");
    }
}
