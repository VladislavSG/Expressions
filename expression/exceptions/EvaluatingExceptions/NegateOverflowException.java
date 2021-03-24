package expression.exceptions.EvaluatingExceptions;

public class NegateOverflowException extends OverflowException{
    public NegateOverflowException() {
        super("Operation negate is overflow");
    }

    public NegateOverflowException(String message) {
        super(message);
    }
}
