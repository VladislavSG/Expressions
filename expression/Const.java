package expression;

import expression.EvaluatingTypes.Calculator;

public class Const<T> implements CommonExpression<T> {
    private T num;

    public Const (T number) {
        this.num = number;
    }

    @Override
    public T evaluate(T x) {
        return num;
    }

    @Override
    public int getLevel() {
        return Operators.maxLevel+1;
    }

    @Override
    public String toMiniString() {
        return num.toString();
    }

    @Override
    public void toMiniString(StringBuilder into) {
        into.append(num.toString());
    }

    @Override
    public void toString(StringBuilder into) {
        toMiniString(into);
    }

    @Override
    public String toString() {
        return toMiniString();
    }

    @Override
    // :NOTE: same as in AbstractEvalType (copy-paste)
    // :ANSWER: Why copy-paste? AbstractEvalType have abstract function equals.
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return (num.equals(((Const)obj).num));
        } else {
            return false;
        }
    }

    @Override
    public String getOperator() {
        return "";
    }

    public int hashCode() {
        return num.hashCode();
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return num;
    }
}
