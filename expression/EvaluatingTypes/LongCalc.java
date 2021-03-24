package expression.EvaluatingTypes;

import expression.exceptions.EvaluatingExceptions.IllegalOperationException;

/**
 * @author Vladislav Gusev (vladislav.sg@yandex.ru)
 */
public class LongCalc extends AbstractCalculator<Long> {
    @Override
    protected boolean addOverflow(Long a, Long b) {
        throw new IllegalOperationException("MyLong:addOverflow");
    }

    @Override
    protected boolean subtractOverflow(Long a, Long b) {
        throw new IllegalOperationException("MyLong:subtractOverflow");
    }

    @Override
    protected boolean multiplyOverflow(Long a, Long b) {
        throw new IllegalOperationException("MyLong:multiplyOverflow");
    }

    @Override
    protected boolean divideOverflow(Long a, Long b) {
        throw new IllegalOperationException("MyLong:divideOverflow");
    }

    @Override
    protected boolean divideByZero(Long l) {
        return l == 0L;
    }

    @Override
    protected boolean negateOverflow(Long l) {
        throw new IllegalOperationException("MyLong:negateOverflow");
    }

    @Override
    public Long add(Long a, Long b) {
        return a + b;
    }

    @Override
    public Long subtract(Long a, Long b) {
        return a - b;
    }

    @Override
    public Long multiply(Long a, Long b) {
        return a * b;
    }

    @Override
    public Long divide(Long a, Long b) {
        return a / b;
    }

    @Override
    public Long abs(Long l) {
        return Math.abs(l);
    }

    @Override
    public Long negate(Long l) {
        return -l;
    }

    @Override
    public Long leftShift(Long a, Long b) {
        return a << b;
    }

    @Override
    public Long rightShift(Long a, Long b) {
        return a >> b;
    }

    @Override
    public Long count(Long l) {
        return (long)Long.bitCount(l);
    }

    @Override
    public Long parse(String s) {
        return Long.parseLong(s);
    }

    @Override
    public Long parse(int x) {
        return (long) x;
    }

    @Override
    public int compareTo(Long a, Long b) {
        return Long.compare(a, b);
    }
}
