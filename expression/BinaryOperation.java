package expression;

import expression.EvaluatingTypes.Calculator;

import java.util.Objects;

public abstract class BinaryOperation<T> extends AbstractOperation<T> {
    protected String operator;
    protected CommonExpression<T> firstExpression;
    protected CommonExpression<T> secondExpression;

    public BinaryOperation (CommonExpression<T> firstExpression, CommonExpression<T> secondExpression, String operator, Calculator<T> calc) {
        super(calc);
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        this.operator = operator;
    }

    @Override
    public String toMiniString() {
        StringBuilder into = new StringBuilder();
        toMiniString(into);
        return into.toString();
    }

    @Override
    public void toMiniString(StringBuilder into) {
        bracketThinkingPrint(into, firstExpression, false);
        into.append(" ");
        into.append(operator);
        into.append(" ");
        bracketThinkingPrint(into, secondExpression, true);
    }

    private void bracketThinkingPrint(StringBuilder into, CommonExpression<T> exp, boolean isSecond) {
        String end = "";
        if (getLevel() > exp.getLevel() || getLevel() == exp.getLevel() && isSecond &&
                (operator.equals("/") || operator.equals("-") || exp.getOperator().equals("/"))) {
            into.append('(');
            end = ")";
        }
        exp.toMiniString(into);
        into.append(end);
    }

    @Override
    public String toString() {
        StringBuilder into = new StringBuilder();
        toString(into);
        return into.toString();
    }

    @Override
    public void toString(StringBuilder into) {
        into.append('(');
        firstExpression.toString(into);
        into.append(" ");
        into.append(operator);
        into.append(" ");
        secondExpression.toString(into);
        into.append(')');
    }

    @Override
    public int getLevel() {
        return Operators.LEVEL.get(operator);
    }

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            BinaryOperation<T> tmp = (BinaryOperation<T>) obj;
            return operator.equals(tmp.operator)
                    && firstExpression.equals(tmp.firstExpression)
                    && secondExpression.equals(tmp.secondExpression);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstExpression.hashCode(), secondExpression.hashCode(), operator.hashCode());
    }
}
