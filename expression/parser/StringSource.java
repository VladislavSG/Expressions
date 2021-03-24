package expression.parser;

import expression.exceptions.ParserException;

public class StringSource implements Source {
    private final String data;
    private int pos;

    public StringSource(final String data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return pos < data.length();
    }

    @Override
    public char next() {
        return data.charAt(pos++);
    }

    @Override
    public RuntimeException error(final String message) {
        return new ParserException(pos - 1 + ": " + message);
    }
}