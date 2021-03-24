package expression.EvaluatingTypes;

// :NOTE: what in "string" divide by "one more string"? where is bounds on type T?
// :ANSWER: java string class don't have operation divide. If someone define class MyString with this operation, then he is responsible for the consistency of this operation.
// For example MyInteger.add(MyInteger) = MyInteger (not Integer)
public interface Calculator<T> {
    T add (T a, T b);

    T checkedAdd (T a, T b);


    T subtract (T a, T b);

    T checkedSubtract (T a, T b);


    T multiply (T a, T b);

    T checkedMultiply (T a, T b);


    T divide (T a, T b);

    T checkedDivide (T a, T b);


    T abs(T t);

    T negate(T t);

    T leftShift(T a, T b);

    T rightShift(T a, T b);

    T count(T t);

    T checkedNegate(T t);

    int compareTo(T a, T b);

    T parse (String s);

    default T parse (int x) {
        return parse(((Integer)x).toString());
    }
    // :NOTE: why type is undefined?
    // :ANSWER: Due to tests I must return Integer instead T=MyInteger. I relied on an example, when evaluating type is Matrix.
    // One alternative is use 2 parameters: T = MyInteger, U = Integer, but I don't want go this way.
}
