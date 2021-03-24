package expression.exceptions.EvaluatingExceptions;

public class MultiplyOverflowException extends OverflowException {
    public MultiplyOverflowException(String message) {
        super(message);
    }

    public MultiplyOverflowException() {
        super("Operation multiply is overflow");
    }
}
