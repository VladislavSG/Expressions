package expression.unchecked_operations;

import expression.CommonExpression;
import expression.EvaluatingTypes.Calculator;
import expression.UnaryOparation;

public class Negate<T> extends UnaryOparation<T> {
    public Negate(CommonExpression<T> expression, Calculator<T> calc) {
        super(expression, "-", calc);
    }

    @Override
    public T evaluate(T x) {
        return calc.negate(expression.evaluate(x));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calc.negate(expression.evaluate(x, y, z));
    }
}
