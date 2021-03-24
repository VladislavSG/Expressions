package expression.generic;

import expression.EvaluatingTypes.*;
import expression.TripleExpression;
import expression.exceptions.EvaluatingExceptions.EvaluateException;
import expression.parser.ExpressionParser;

import java.util.Map;
import java.util.Set;

public class GenericTabulator<T> implements Tabulator {
    private static final Set<String> UNCHECKED = Set.of(
            "u", "l", "s"
    );

    private final Map<String, Calculator> MODES = Map.of(
            "i", new IntegerCalc(),
            "d", new DoubleCalc(),
            "bi", new BigIntCalc(),
            "u", new IntegerCalc(),
            "l", new LongCalc(),
            "s", new ShortCalc()
    );

    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        Object[][][] table = new Object[x2-x1+1][y2-y1+1][z2-z1+1];

        if (!MODES.containsKey(mode))
            throw new Exception("Unexpected mode");
        Calculator<T> calc = MODES.get(mode);
        boolean check = !UNCHECKED.contains(mode);

        TripleExpression<T> tripleExpression = new ExpressionParser<>(check, calc).parse(expression);

        for (int i = 0; i <= x2 - x1; i++) {
            for (int j = 0; j <= y2 - y1; j++) {
                for (int k = 0; k <= z2 - z1; k++) {
                    try {
                        table[i][j][k] = tripleExpression.evaluate(calc.parse(x1 + i), calc.parse(y1 + j), calc.parse(z1 + k));
                    } catch (EvaluateException | ArithmeticException e) {
                        table[i][j][k] = null;
                    }
                }
            }
        }
        return table;
    }
}
