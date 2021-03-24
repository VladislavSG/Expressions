package expression.checked_operations;

import expression.CommonExpression;
import expression.EvaluatingTypes.Calculator;
import expression.unchecked_operations.Negate;

public class CheckedNegate<T> extends Negate<T> {
    public CheckedNegate(CommonExpression<T> expression, Calculator<T> calc) {
        super(expression, calc);
    }

    @Override
    public T evaluate(T x) {
        return calc.checkedNegate(expression.evaluate(x));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calc.checkedNegate(expression.evaluate(x, y, z));
    }
}
