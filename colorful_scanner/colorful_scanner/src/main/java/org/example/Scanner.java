package org.example;
import java.util.ArrayList;
import java.util.List;

public class Scanner {
    private String input;
    private int pos = 0;
    private List<Token> tokens = new ArrayList<>();

    public Scanner(String input) {
        this.input = input;
    }

    public void scanTokens() {
        while (pos < input.length()) {
            char current = input.charAt(pos);

            if (Character.isWhitespace(current)) {
                pos++; continue;
            }

            // comments
            if (current == '/' && pos + 1 < input.length() && input.charAt(pos + 1) == '/') {
                StringBuilder sb = new StringBuilder();
                while (pos < input.length() && input.charAt(pos) != '\n') {
                    sb.append(input.charAt(pos));
                    pos++;
                }
                tokens.add(new Token(TokenCode.COMMENT, sb.toString()));
                continue;
            }

            // integers
            if (Character.isDigit(current)) {
                StringBuilder sb = new StringBuilder();
                while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
                    sb.append(input.charAt(pos));
                    pos++;
                }
                tokens.add(new Token(TokenCode.INT, sb.toString()));

                // crucial_words and id
            } else if (Character.isLetter(current) || current == '_') {
                StringBuilder sb = new StringBuilder();
                while (pos < input.length() && (Character.isLetterOrDigit(input.charAt(pos)) || input.charAt(pos) == '_')) {
                    sb.append(input.charAt(pos));
                    pos++;
                }
                String word = sb.toString();
                switch (word) {
                    case "if":     tokens.add(new Token(TokenCode.IF,    word)); break;
                    case "while":  tokens.add(new Token(TokenCode.WHILE, word)); break;
                    case "for":    tokens.add(new Token(TokenCode.FOR,   word)); break;
                    case "else":   tokens.add(new Token(TokenCode.ELSE,  word)); break;
                    default:       tokens.add(new Token(TokenCode.ID,    word)); break;
                }

            } else {
                switch (current) {
                    case '=':
                        if (pos + 1 < input.length() && input.charAt(pos + 1) == '=') {
                            tokens.add(new Token(TokenCode.EQUALS, "==")); pos++;
                        } else {
                            tokens.add(new Token(TokenCode.ASSIGN, "="));
                        }
                        break;

                    case '+': tokens.add(new Token(TokenCode.PLUS,"+")); break;
                    case '-': tokens.add(new Token(TokenCode.MINUS,"-")); break;
                    case '*': tokens.add(new Token(TokenCode.MUL,"*")); break;
                    case '/': tokens.add(new Token(TokenCode.DIV,"/")); break;
                    case '%': tokens.add(new Token(TokenCode.MOD,"%")); break;
                    case '(': tokens.add(new Token(TokenCode.LPAREN,"(")); break;
                    case ')': tokens.add(new Token(TokenCode.RPAREN,")")); break;
                    case '{': tokens.add(new Token(TokenCode.LBRACE,"{")); break;
                    case '}': tokens.add(new Token(TokenCode.RBRACE,"}")); break;
                    case ';': tokens.add(new Token(TokenCode.SEMICOLON,";")); break;
                    case '<': tokens.add(new Token(TokenCode.LT,"<")); break;
                    case '>': tokens.add(new Token(TokenCode.GT,">")); break;
                    default:
                        System.err.println("Nieznany znak: " + current);
                        tokens.add(new Token(TokenCode.EOF, ""));
                        return;
                }
                pos++;
            }
        }
        tokens.add(new Token(TokenCode.EOF, ""));
    }

    public void listTokens() {
        for (Token t : tokens) {
            System.out.println(t);
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }
}