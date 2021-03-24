package expression.unchecked_operations;

import expression.BinaryOperation;
import expression.CommonExpression;
import expression.EvaluatingTypes.Calculator;

public class Add<T> extends BinaryOperation<T> {
    public Add(CommonExpression<T> firstExpression, CommonExpression<T> secondExpression, Calculator<T> calc) {
        super(firstExpression, secondExpression, "+", calc);
    }

    @Override
    public T evaluate(T x) {
        return calc.add(firstExpression.evaluate(x), secondExpression.evaluate(x));
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calc.add(firstExpression.evaluate(x, y, z), secondExpression.evaluate(x, y, z));
    }
}
