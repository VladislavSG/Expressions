package expression;

import expression.EvaluatingTypes.Calculator;

public interface TripleExpression<T> extends ToMiniString {
    T evaluate(T x, T y, T z);
}
