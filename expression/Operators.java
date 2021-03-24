package expression;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Operators {
    public static final Map<String, Integer> LEVEL = Map.of(
            "min", 0,
            "max", 0,
            "<<", 1,
            ">>", 1,
            "+", 2,
            "-", 2,
            "*", 3,
            "/", 3
    );

    public static final Set<String> UNARY_OPERATIONS = Set.of(
        "-", "abs", "count", "square"
    );

    public static final int minLevel = Collections.min(LEVEL.values());
    public static final int maxLevel = Collections.max(LEVEL.values());

    public static int getLevel(String op) {
        return LEVEL.getOrDefault(op, minLevel - 1);
    }

    public static final Set<String> NOTASSOCIATIVE = Set.of(
            "-", "/", "<<", ">>"
    );

    public static boolean isNotAssociative(String op) {
        return NOTASSOCIATIVE.contains(op);
    }
}
