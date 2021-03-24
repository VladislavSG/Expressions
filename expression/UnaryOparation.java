package expression;

import expression.EvaluatingTypes.Calculator;

public abstract class UnaryOparation<T> extends AbstractOperation<T> {
    protected String operator;
    protected CommonExpression<T> expression;

    public UnaryOparation(CommonExpression<T> expression, String operator, Calculator<T> calc) {
        super(calc);
        this.operator = operator;
        this.expression = expression;
    }

    @Override
    public String toMiniString() {
        boolean hasBrackets = !(expression instanceof Variable || expression instanceof Const)
                && (expression instanceof BinaryOperation);
        return operator + (hasBrackets ? "(" : "") + expression.toMiniString() + (hasBrackets ? ")" : "");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void toString(StringBuilder into) {
        into.append(toString());
    }

    @Override
    public void toMiniString(StringBuilder into) {
        into.append(toMiniString());
    }

    @Override
    public int getLevel() {
        return 100;
    }

    @Override
    public String toString() {
        return operator + "(" + expression.toString() + ")";
    }

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            UnaryOparation<T> tmp = (UnaryOparation) obj;
            return operator.equals(tmp.operator)
                    && expression.equals(tmp.expression);
        }
        return false;
    }
}
