package expression;

import expression.EvaluatingTypes.Calculator;

/**
 * @author Vladislav Gusev (vladislav.sg@yandex.ru)
 */
public abstract class AbstractOperation<T> implements CommonExpression<T> {
    protected Calculator<T> calc;

    public AbstractOperation(Calculator<T> calc) {
        this.calc = calc;
    }
}
