package expression.unchecked_operations;

import expression.CommonExpression;
import expression.UnaryOparation;

import expression.EvaluatingTypes.Calculator;

public class Abs<T> extends UnaryOparation<T> {
    public Abs(CommonExpression<T> expression, Calculator<T> calc) {
        super(expression, "abs ", calc);
    }

    @Override
    public T evaluate(T x) {
        return calc.abs(expression.evaluate(x));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calc.abs(expression.evaluate(x, y, z));
    }
}
