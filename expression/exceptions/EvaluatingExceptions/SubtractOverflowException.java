package expression.exceptions.EvaluatingExceptions;

public class SubtractOverflowException extends OverflowException {
    public SubtractOverflowException() {
        super("Operation subtract is overflow");
    }

    public SubtractOverflowException(String message) {
        super(message);
    }
}
