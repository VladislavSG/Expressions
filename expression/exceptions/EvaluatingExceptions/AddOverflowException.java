package expression.exceptions.EvaluatingExceptions;

public class AddOverflowException extends OverflowException{
    public AddOverflowException() {
        super("Operation add is overflow");
    }

    public AddOverflowException(String message) {
        super(message);
    }
}
