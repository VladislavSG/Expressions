package expression.parser;

public class BaseParser {
    private Source source;
    protected char ch;

    public void setSource(Source source) {
        this.source = source;
    }

    protected void nextChar() {
        ch = source.hasNext() ? source.next() : '\0';
    }

    protected boolean test(char expected) {
        if (ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }

    protected void expect(final char c) {
        if (ch != c) {
            throw error("Expected '" + c + "', found '" + ch + "'");
        }
        nextChar();
    }

    protected void expect(final String value) {
        for (char c : value.toCharArray()) {
            expect(c);
        }
    }

    protected boolean nextIsDigit() {
        return isDigit(ch);
    }

    protected boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    protected RuntimeException error(final String message) {
        return source.error(message);
    }

    protected void skipWhitespaces() {
        while (Character.isWhitespace(ch)) {
            nextChar();
        }
    }
}
