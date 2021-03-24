package expression.EvaluatingTypes;

import expression.exceptions.EvaluatingExceptions.IllegalOperationException;

/**
 * @author Vladislav Gusev (vladislav.sg@yandex.ru)
 */
public class ShortCalc extends AbstractCalculator<Short> {
    @Override
    protected boolean addOverflow(Short a, Short b) {
        throw new IllegalOperationException("MyShort:addOverflow");
    }

    @Override
    protected boolean subtractOverflow(Short a, Short b) {
        throw new IllegalOperationException("MyShort:subtractOverflow");
    }

    @Override
    protected boolean multiplyOverflow(Short a, Short b) {
        throw new IllegalOperationException("MyShort:multiplyOverflow");
    }

    @Override
    protected boolean divideOverflow(Short a, Short b) {
        throw new IllegalOperationException("MyShort:divideOverflow");
    }

    @Override
    protected boolean divideByZero(Short s) {
        return s == 0;
    }

    @Override
    protected boolean negateOverflow(Short s) {
        throw new IllegalOperationException("MyShort:negateOverflow");
    }

    @Override
    public Short add(Short a, Short b) {
        return (short)(a + b);
    }

    @Override
    public Short subtract(Short a, Short b) {
        return (short)(a - b);
    }

    @Override
    public Short multiply(Short a, Short b) {
        return (short)(a * b);
    }

    @Override
    public Short divide(Short a, Short b) {
        return (short)(a / b);
    }

    @Override
    public Short abs(Short s) {
        return (short)Math.abs(s);
    }

    @Override
    public Short negate(Short s) {
        return (short)-s;
    }

    @Override
    public Short leftShift(Short a, Short b) {
        return (short)(a << b);
    }

    @Override
    public Short rightShift(Short a, Short b) {
        return (short)(a >> b);
    }

    @Override
    public Short count(Short s) {
        return (short)Integer.bitCount(Short.toUnsignedInt(s));
    }

    @Override
    public Short parse(String s) {
        return Short.parseShort(s);
    }

    @Override
    public Short parse(int x) {
        return (short)x;
    }

    @Override
    public int compareTo(Short a, Short b) {
        return Short.compare(a, b);
    }
}
