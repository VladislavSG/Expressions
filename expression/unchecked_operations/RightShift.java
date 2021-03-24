package expression.unchecked_operations;

import expression.BinaryOperation;
import expression.CommonExpression;
import expression.EvaluatingTypes.Calculator;

public class RightShift<T> extends BinaryOperation<T> {
    public RightShift(CommonExpression<T> firstExpression, CommonExpression<T> secondExpression, Calculator<T> calc) {
        super(firstExpression, secondExpression, "<<", calc);
    }

    @Override
    public T evaluate(T x) {
        return calc.rightShift(firstExpression.evaluate(x), secondExpression.evaluate(x));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calc.rightShift(firstExpression.evaluate(x, y, z), secondExpression.evaluate(x, y, z));
    }
}