package expression;

import expression.EvaluatingTypes.Calculator;

public interface CommonExpression<T> extends Expression<T>, TripleExpression<T> {
    void toString(StringBuilder into);
    void toMiniString(StringBuilder into);
    int getLevel();
    String getOperator();
}
