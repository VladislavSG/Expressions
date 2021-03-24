package expression;

import expression.EvaluatingTypes.Calculator;

public interface Expression<T> extends ToMiniString {
    T evaluate(T x);
}
