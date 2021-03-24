package expression.unchecked_operations;

import expression.CommonExpression;
import expression.EvaluatingTypes.Calculator;
import expression.UnaryOparation;

public class Count<T> extends UnaryOparation<T> {
    public Count(CommonExpression<T> expression, Calculator<T> calc) {
        super(expression, "count", calc);
    }

    @Override
    public T evaluate(T x) {
        return calc.count(expression.evaluate(x));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calc.count(expression.evaluate(x, y, z));
    }
}
