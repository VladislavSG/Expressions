package expression.unchecked_operations;

import expression.BinaryOperation;
import expression.CommonExpression;
import expression.EvaluatingTypes.Calculator;

/**
 * @author Vladislav Gusev (vladislav.sg@yandex.ru)
 */
public class Min<T> extends BinaryOperation<T> {
    public Min(CommonExpression<T> firstExpression, CommonExpression<T> secondExpression, Calculator<T> calc) {
        super(firstExpression, secondExpression, "min", calc);
    }

    @Override
    public T evaluate(T x) {
        T f = firstExpression.evaluate(x);
        T s = secondExpression.evaluate(x);
        return (calc.compareTo(f, s) <= 0 ? f : s);
    }

    @Override
    public T evaluate(T x, T y, T z) {
        T f = firstExpression.evaluate(x, y, z);
        T s = secondExpression.evaluate(x, y, z);
        return (calc.compareTo(f, s) <= 0 ? f : s);
    }
}
