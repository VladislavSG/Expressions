package expression.EvaluatingTypes;

public class IntegerCalc extends AbstractCalculator<Integer> {
    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        return a / b;
    }

    @Override
    public Integer abs(Integer x) {
        return Math.abs(x);
    }

    @Override
    public Integer negate(Integer x) {
        return -x;
    }

    @Override
    public Integer leftShift(Integer a, Integer b) {
        return a << b;
    }

    @Override
    public Integer rightShift(Integer a, Integer b) {
        return a >> b;
    }

    @Override
    public boolean addOverflow(Integer a, Integer b) {
        return (b > 0 && Integer.MAX_VALUE - b < a ||
                b < 0 && Integer.MIN_VALUE - b > a);
    }

    @Override
    public boolean multiplyOverflow(Integer a, Integer b) {
        return  (a != 0 && b != 0) && (
                (a == Integer.MIN_VALUE && b == -1 || a == -1 && b == Integer.MIN_VALUE) ||
                        ((a == Integer.MIN_VALUE && b != 1) || (a != 1 && b == Integer.MIN_VALUE)) ||
                        (Integer.MAX_VALUE / abs(a) < abs(b)));
    }

    @Override
    public boolean subtractOverflow(Integer a, Integer b) {
        return (b > 0 && Integer.MIN_VALUE + b > a ||
                    b < 0 && Integer.MAX_VALUE + b < a);
    }

    @Override
    public boolean divideByZero(Integer x) {
        return x == 0;
    }

    @Override
    public boolean divideOverflow(Integer a, Integer b) {
        return a == Integer.MIN_VALUE && b == -1;
    }

    @Override
    public Integer parse(String s) {
        return Integer.parseInt(s);
    }

    @Override
    public Integer parse(int x) {
        return x;
    }

    @Override
    protected boolean negateOverflow(Integer x) {
        return x == Integer.MIN_VALUE;
    }

    @Override
    public Integer count(Integer x) {
        return Integer.bitCount(x);
    }

    @Override
    public int compareTo(Integer a, Integer b) {
        return Integer.compare(a, b);
    }
}
