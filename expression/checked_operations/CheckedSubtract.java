package expression.checked_operations;

import expression.CommonExpression;
import expression.EvaluatingTypes.Calculator;
import expression.unchecked_operations.Subtract;

public class CheckedSubtract<T> extends Subtract<T> {
    public CheckedSubtract(CommonExpression<T> firstExpression, CommonExpression<T> secondExpression, Calculator<T> calc) {
        super(firstExpression, secondExpression, calc);
    }

    @Override
    public T evaluate(T x) {
        return calc.checkedSubtract(firstExpression.evaluate(x), secondExpression.evaluate(x));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calc.checkedSubtract(firstExpression.evaluate(x, y, z), secondExpression.evaluate(x, y, z));
    }
}
