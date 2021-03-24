package expression.parser;

import expression.EvaluatingTypes.Calculator;
import expression.TripleExpression;
import expression.exceptions.ParserException;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface Parser<T> {
    TripleExpression<T> parse(String expression) throws ParserException;
}
