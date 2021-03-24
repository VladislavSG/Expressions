package expression.exceptions.EvaluatingExceptions;

public class DivideOverflowException extends OverflowException{
    public DivideOverflowException() {
        super("Operation divide is overflow");
    }

    public DivideOverflowException(String message) {
        super(message);
    }
}
