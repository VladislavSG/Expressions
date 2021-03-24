package expression.EvaluatingTypes;

import expression.exceptions.EvaluatingExceptions.IllegalOperationException;

public class DoubleCalc extends AbstractCalculator<Double> {
    @Override
    protected boolean addOverflow(Double a, Double b) {
        return false;
    }

    @Override
    protected boolean subtractOverflow(Double a, Double b) {
        return false;
    }

    @Override
    protected boolean multiplyOverflow(Double a, Double b) {
        return false;
    }

    @Override
    protected boolean divideOverflow(Double a, Double b) {
        return false;
    }

    @Override
    protected boolean divideByZero(Double d) {
        return d == 0.0;
    }

    @Override
    public Double checkedDivide(Double a, Double b) {
        return divide(a, b);
    }

    @Override
    protected boolean negateOverflow(Double d) {
        return false;
    }

    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double subtract(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double divide(Double a, Double b) {
        return a / b;
    }

    @Override
    public Double abs(Double d) {
        return Math.abs(d);
    }

    @Override
    public Double negate(Double d) {
        return -d;
    }

    @Override
    public Double leftShift(Double a, Double b) {
        throw new IllegalOperationException("MyDouble:leftShift");
    }

    @Override
    public Double rightShift(Double a, Double b) {
        throw new IllegalOperationException("MyDouble:rightShift");
    }

    @Override
    public Double count(Double d) {
        return (double)Long.bitCount(Double.doubleToLongBits(d));
    }

    @Override
    public Double parse(String x) {
        return Double.parseDouble(x);
    }

    @Override
    public int compareTo(Double a, Double b) {
        return Double.compare(a, b);
    }
}
