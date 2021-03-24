package expression.EvaluatingTypes;

import java.math.BigInteger;

public class BigIntCalc extends AbstractCalculator<BigInteger> {
    @Override
    protected boolean addOverflow(BigInteger a, BigInteger b) {
        return false;
    }

    @Override
    protected boolean subtractOverflow(BigInteger a, BigInteger b) {
        return false;
    }

    @Override
    protected boolean multiplyOverflow(BigInteger a, BigInteger b) {
        return false;
    }

    @Override
    protected boolean divideOverflow(BigInteger a, BigInteger b) {
        return false;
    }

    @Override
    protected boolean divideByZero(BigInteger t) {
        return t.equals(BigInteger.ZERO);
    }

    @Override
    protected boolean negateOverflow(BigInteger t) {
        return false;
    }

    @Override
    public BigInteger add(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    @Override
    public BigInteger subtract(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    @Override
    public BigInteger multiply(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    @Override
    public BigInteger divide(BigInteger a, BigInteger b) {
        return a.divide(b);
    }

    @Override
    public BigInteger abs(BigInteger t) {
        return t.abs();
    }

    @Override
    public BigInteger negate(BigInteger t) {
        return t.negate();
    }

    @Override
    public BigInteger leftShift(BigInteger a, BigInteger b) {
        return a.shiftLeft(b.intValue());
    }

    @Override
    public BigInteger rightShift(BigInteger a, BigInteger b) {
        return a.shiftRight(b.intValue());
    }

    @Override
    public BigInteger count(BigInteger t) {
        return new BigInteger(((Integer)t.bitCount()).toString());
    }

    @Override
    public int compareTo(BigInteger a, BigInteger b) {
        return a.compareTo(b);
    }

    @Override
    public BigInteger parse(String s) {
        return new BigInteger(s);
    }
}
