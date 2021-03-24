package expression.checked_operations;

import expression.EvaluatingTypes.Calculator;
import expression.CommonExpression;
import expression.unchecked_operations.Multiply;

public class CheckedMultiply<T> extends Multiply<T> {
    public CheckedMultiply(CommonExpression<T> firstExpression, CommonExpression<T> secondExpression, Calculator<T> calc) {
        super(firstExpression, secondExpression, calc);
    }

    @Override
    public T evaluate(T x) {
        return calc.checkedMultiply(firstExpression.evaluate(x), secondExpression.evaluate(x));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calc.checkedMultiply(firstExpression.evaluate(x, y, z), secondExpression.evaluate(x, y, z));
    }
}
