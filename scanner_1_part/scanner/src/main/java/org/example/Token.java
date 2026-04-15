package org.example;

public class Token {

    private final TokenCode code;
    private final String text;

    public Token(TokenCode code, String text) {
        this.code = code;
        this.text = text;
    }

    public TokenCode getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Token[" + code + ", '" + text + "']";
    }

}
