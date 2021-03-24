import expression.EvaluatingTypes.IntegerCalc;
import expression.parser.*;

public class Main {
    public static void main(String[] args) {
        ExpressionParser<Integer> parser = new ExpressionParser<>(new IntegerCalc());
        System.out.println(parser.parse("(((x+4)*3)/z)").toMiniString());
    }
}