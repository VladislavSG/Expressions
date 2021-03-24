package expression.parser;

import expression.Operators;
import expression.*;
import expression.EvaluatingTypes.Calculator;
import expression.checked_operations.*;
import expression.exceptions.EvaluatingExceptions.EvaluateException;
import expression.exceptions.ParserException;
import expression.unchecked_operations.*;

import java.util.HashSet;
import java.util.Set;

public class ExpressionParser<T> extends BaseParser implements Parser<T> {
    private String lastOperator = "";
    private static final int topLevel = Operators.minLevel;
    private static final int primeLevel = Operators.maxLevel + 1;
    private static int insideLvl = 0;
    boolean check;
    private Calculator<T> calc;

    private static final Set<String> PREFIX_OPERATORS = constructPrefixSet(Operators.LEVEL.keySet());

    private static final Set<String> PREFIX_VARIABLES = constructPrefixSet(Variable.VARIABLES.keySet());

    private static final Set<String> PREFIX_UNARY_OPERATIONS = constructPrefixSet(Operators.UNARY_OPERATIONS);

    private static Set<String> constructPrefixSet(Set<String> mainSet) {
        Set<String> s = new HashSet<>();
        for (String elem : mainSet) {
            StringBuilder pref = new StringBuilder();
            for (int i = 0; i < elem.length(); i++) {
                pref.append(elem.charAt(i));
                s.add(pref.toString());
            }
        }
        return s;
    }

    public ExpressionParser(boolean check, Calculator<T> calc) {
        this.check = check;
        this.calc = calc;
        PREFIX_OPERATORS.add("\0");
        PREFIX_OPERATORS.add(")");
    }

    public ExpressionParser(Calculator<T> calc) {
        this(true, calc);
    }

    @Override
    public TripleExpression<T> parse(String expression) throws ParserException {
        setSource(new StringSource(expression));
        nextChar();
        insideLvl = 0;
        skipWhitespaces();
        return parseLevel(topLevel);
    }

    private CommonExpression<T> parseLevel(int parseLvl) {
        if (parseLvl >= primeLevel) {
            CommonExpression<T> primeExpression;
            if (test('(')) {
                insideLvl++;
                primeExpression = parseLevel(topLevel);
            } else
                primeExpression = parsePrime();
            skipWhitespaces();
            return primeExpression;
        }
        CommonExpression<T> expression = parseLevel(parseLvl + 1);
        while (Operators.LEVEL.getOrDefault(lastOperator, topLevel-1) == parseLvl) {
            expression = makeExpression(lastOperator, expression, parseLevel(parseLvl + 1));
        }
        if (parseLvl == topLevel) {
            if (lastOperator.equals(")")) {
                if (insideLvl <= 0)
                    throw new EvaluateException("Expected extra ')'");
                else
                    insideLvl--;
            } else if (insideLvl != 0)
                throw error("Unexpected ')'");
            testOperator();
        }
        return expression;
    }

    private CommonExpression<T> parsePrime() {
        if (test('(')) {
            skipWhitespaces();
            insideLvl++;
            return parseLevel(topLevel);
        }
        if (test('-')) {
            skipWhitespaces();
            if (nextIsDigit()) {
                return parseConst(true);
            } else {
                if (check)
                    return new CheckedNegate<>(parsePrime(), calc);
                else
                    return new Negate<>(parsePrime(), calc);
            }
        } else if (test('a')) {
            expect("bs");
            skipWhitespaces();
            return new Abs<>(parsePrime(), calc);
        } else if (test('s')) {
            expect("quare");
            skipWhitespaces();
            return new Square<>(parsePrime(), calc);
        } else if (test('c')) {
            expect("ount");
            skipWhitespaces();
            return new Count<>(parsePrime(), calc);
        } else if (nextIsDigit()) {
            return parseConst(false);
        } else {
            return parseVariable();
        }
    }

    private CommonExpression<T> parseVariable() {
        if (PREFIX_VARIABLES.contains(String.valueOf(ch))) {
            String var = maxSetIncluded(PREFIX_VARIABLES);
            if (!Variable.VARIABLES.containsKey(var))
                throw error("Expected variable, found: "+ var);
            skipWhitespaces();
            testOperator();
            return new Variable<>(var);
        } else {
            throw error("Expected variable, found: "+ ch);
        }
    }

    private CommonExpression<T> parseConst(boolean isNegative) {
        StringBuilder constConstuctor = new StringBuilder(isNegative ? "-" : "");
        while (nextIsDigit()) {
            constConstuctor.append(ch);
            nextChar();
        }
        skipWhitespaces();
        testOperator();
        try {
            return new Const<>(calc.parse(constConstuctor.toString()));
        } catch (NumberFormatException e) {
            throw new ParserException("Constant overflow: " + constConstuctor.toString());
        }
    }

    private void testOperator() {
        if (PREFIX_OPERATORS.contains(String.valueOf(ch)))
            lastOperator = maxSetIncluded(PREFIX_OPERATORS);
        else
            throw error("Expected operator, actual: " + ch);
        skipWhitespaces();
    }

    private String maxSetIncluded(Set<String> prefixSet) {
        StringBuilder pref = new StringBuilder().append(ch);
        while (prefixSet.contains(pref.toString())) {
            nextChar();
            pref.append(ch);
        }
        return pref.deleteCharAt(pref.length()-1).toString();
    }

    private CommonExpression<T> makeExpression(String operator, CommonExpression<T> a, CommonExpression<T> b) {
        if (check) {
            if (operator.equals("+")) {
                return new CheckedAdd<>(a, b, calc);
            }
            if (operator.equals("-")) {
                return new CheckedSubtract<>(a, b, calc);
            }
            if (operator.equals("*")) {
                return new CheckedMultiply<>(a, b, calc);
            }
            if (operator.equals("/")) {
                return new CheckedDivide<>(a, b, calc);
            }
        } else {
            if (operator.equals("+")) {
                return new Add<>(a, b, calc);
            }
            if (operator.equals("-")) {
                return new Subtract<>(a, b, calc);
            }
            if (operator.equals("*")) {
                return new Multiply<>(a, b, calc);
            }
            if (operator.equals("/")) {
                return new Divide<>(a, b, calc);
            }
        }
        if (operator.equals("<<")) {
            return new LeftShift<>(a, b, calc);
        }
        if (operator.equals(">>")) {
            return new RightShift<>(a, b, calc);
        }
        if (operator.equals("min")) {
            return new Min<>(a, b, calc);
        }
        if (operator.equals("max")) {
            return new Max<>(a, b, calc);
        }
        throw error("Unsupported operator: " + operator);
    }
}
