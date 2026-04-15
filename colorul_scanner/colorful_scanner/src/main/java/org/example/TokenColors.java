package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenColors {

    private final Map<TokenCode, String> color_types;

    TokenColors() {
        color_types = new HashMap<>();

        color_types.put(TokenCode.YELLOW, "#FFFF00");
        color_types.put(TokenCode.GREEN, "#00FF00");
        color_types.put(TokenCode.BLUE, "#00FFFF");
        color_types.put(TokenCode.RED, "#FF0000");
        color_types.put(TokenCode.WHITE, "#FFFFFF");
        color_types.put(TokenCode.CYAN, "#00FFFF");
        color_types.put(TokenCode.MAGENTA, "#FF00FF");
        color_types.put(TokenCode.GREY, "#888888");
        color_types.put(TokenCode.B_RED, "#FF6666");
        color_types.put(TokenCode.B_GREEN, "#66FF66");
        color_types.put(TokenCode.B_YELLOW, "#FFFF99");
        color_types.put(TokenCode.B_BLUE, "#99CCFF");
    }

    public void colorful(List<Token> token_list) {

        StringBuilder htmlResult = new StringBuilder();
        htmlResult.append("<html><body style='background:#282c34; font-family:monospace; white-space:pre;'>");

        for (Token t : token_list) {
            String color;

            switch (t.getCode()) {
                case INT:
                    color = color_types.get(TokenCode.B_BLUE);
                    break;

                case ID:
                    color = color_types.get(TokenCode.GREEN);
                    break;

                case IF:
                case ELSE:
                case WHILE:
                case FOR:
                    color = color_types.get(TokenCode.YELLOW);
                    break;

                case LPAREN:
                case RPAREN:
                    color = color_types.get(TokenCode.MAGENTA);
                    break;

                case LBRACE:
                case RBRACE:
                    color = color_types.get(TokenCode.B_YELLOW);
                    break;

                case PLUS:
                case MINUS:
                case MUL:
                case DIV:
                case MOD:
                    color = color_types.get(TokenCode.WHITE);
                    break;

                case ASSIGN:
                case EQUALS:
                    color = color_types.get(TokenCode.CYAN);
                    break;

                case SEMICOLON:
                    color = color_types.get(TokenCode.GREY);
                    break;

                case LT:
                case GT:
                    color = color_types.get(TokenCode.B_RED);
                    break;

                case COMMENT:
                    color = color_types.get(TokenCode.B_GREEN);
                    break;

                case EOF:
                    color = color_types.get(TokenCode.RED);
                    break;

                default:
                    color = color_types.get(TokenCode.WHITE);
                    break;
            }

            String displayText;
            if (t.getCode() == TokenCode.EOF) {
                displayText = "[EOF]";
            } else {
                displayText = t.getText();
            }

            htmlResult.append("<span style='color:").append(color).append(";'>")
                    .append(displayText)
                    .append("</span>")
                    .append(" ");
        }

        htmlResult.append("</body></html>");

        try {
            Files.writeString(Paths.get("kolorowy_skaner.html"), htmlResult.toString());
            System.out.println("Plik kolorowy_skaner.html został utworzony.");
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu pliku: " + e.getMessage());
        }
    }
}