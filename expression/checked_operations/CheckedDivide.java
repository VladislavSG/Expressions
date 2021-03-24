package expression.checked_operations;

import expression.CommonExpression;
import expression.EvaluatingTypes.Calculator;
import expression.unchecked_operations.Divide;

public class CheckedDivide<T> extends Divide<T> {
    public CheckedDivide(CommonExpression<T> firstExpression, CommonExpression<T> secondExpression, Calculator<T> calc) {
        super(firstExpression, secondExpression, calc);
    }

    @Override
    public T evaluate(T x) {
        return calc.checkedDivide(firstExpression.evaluate(x), secondExpression.evaluate(x));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calc.checkedDivide(firstExpression.evaluate(x, y, z), secondExpression.evaluate(x, y, z));
    }
}
