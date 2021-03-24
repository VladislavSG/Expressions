package expression.unchecked_operations;

import expression.CommonExpression;
import expression.EvaluatingTypes.Calculator;
import expression.UnaryOparation;

public class Square<T> extends UnaryOparation<T> {
    public Square(CommonExpression<T> expression, Calculator<T> calc) {
        super(expression, "square ", calc);
    }

    @Override
    public T evaluate(T x) {
        T temp = expression.evaluate(x);
        return calc.multiply(temp, temp);
    }

    @Override
    public T evaluate(T x, T y, T z) {
        T temp = expression.evaluate(x, y, z);
        return calc.multiply(temp, temp);
    }
}
