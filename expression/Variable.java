package expression;

import expression.EvaluatingTypes.Calculator;

import java.util.List;
import java.util.Map;

public class Variable<T> implements CommonExpression<T> {
    private final String var;
    public static final Map<String, Integer> VARIABLES = Map.of(
            "x", 0,
            "y", 1,
            "z", 2
    );

    public Variable(String var) {
        this.var = var;
    }

    @Override
    public int getLevel() {
        return Operators.maxLevel+1;
    }

    @Override
    public String toMiniString() {
        return var;
    }

    @Override
    public void toMiniString(StringBuilder into) {
        into.append(var);
    }

    @Override
    public void toString(StringBuilder into) {
        into.append(var);
    }

    @Override
    public String toString() {
        return var;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return var.equals(((Variable)obj).var);
        } else {
            return false;
        }
    }

    @Override
    public String getOperator() {
        return "";
    }

    public int hashCode() {
        return var.hashCode();
    }

    @Override
    public T evaluate(T x) {
        return x;
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return List.of(x, y, z).get(VARIABLES.get(var));
    }
}
