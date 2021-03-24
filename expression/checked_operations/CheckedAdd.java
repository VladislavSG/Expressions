package expression.checked_operations;

import expression.EvaluatingTypes.Calculator;
import expression.unchecked_operations.Add;
import expression.CommonExpression;

public class CheckedAdd<T> extends Add<T> {
    public CheckedAdd(CommonExpression<T> firstExpression, CommonExpression<T> secondExpression, Calculator<T> calc) {
        super(firstExpression, secondExpression, calc);
    }

    @Override
    public T evaluate(T x) {
        return calc.checkedAdd(firstExpression.evaluate(x), secondExpression.evaluate(x));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calc.checkedAdd(firstExpression.evaluate(x, y, z), secondExpression.evaluate(x, y, z));
}
}
