package expression.EvaluatingTypes;

import expression.exceptions.EvaluatingExceptions.*;

public abstract class AbstractCalculator<T> implements Calculator<T> {
    @Override
    public T checkedAdd(T a, T b) {
        if (addOverflow(a, b))
            throw new AddOverflowException();
        else
            return add(a, b);
    }

    protected abstract boolean addOverflow(T a, T b);

    @Override
    public T checkedSubtract(T a, T b) {
        if (subtractOverflow(a, b))
            throw new SubtractOverflowException();
        else
            return subtract(a, b);
    }

    protected abstract boolean subtractOverflow(T a, T b);

    @Override
    public T checkedMultiply(T a, T b) {
        if (multiplyOverflow(a, b))
            throw new MultiplyOverflowException();
        else
            return multiply(a, b);
    }

    protected abstract boolean multiplyOverflow(T a, T b);

    @Override
    public T checkedDivide(T a, T b) {
        if (divideByZero(b)) {
            throw new DivideByZeroException();
        } else if (divideOverflow(a, b))
            throw new DivideOverflowException();
        else
            return divide(a, b);
    }

    protected abstract boolean divideOverflow(T a, T b);

    protected abstract boolean divideByZero(T t);

    @Override
    public T checkedNegate(T t) {
        if (negateOverflow(t))
            throw new NegateOverflowException();
        else
            return negate(t);
    }

    protected abstract boolean negateOverflow(T t);
}
