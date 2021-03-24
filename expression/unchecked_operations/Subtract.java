package expression.unchecked_operations;

import expression.BinaryOperation;
import expression.CommonExpression;
import expression.EvaluatingTypes.Calculator;

public class Subtract<T> extends BinaryOperation<T> {
    public Subtract(CommonExpression<T> firstExpression, CommonExpression<T> secondExpression, Calculator<T> calc) {
        super(firstExpression, secondExpression, "-", calc);
    }

    @Override
    public T evaluate(T x) {
        return calc.subtract(firstExpression.evaluate(x), secondExpression.evaluate(x));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calc.subtract(firstExpression.evaluate(x, y, z), secondExpression.evaluate(x, y, z));
    }
}
