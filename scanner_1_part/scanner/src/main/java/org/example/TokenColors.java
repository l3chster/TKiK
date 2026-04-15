package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    }

    public void colorful(List<Token> token_list){

        StringBuilder htmlResult = new StringBuilder();
        htmlResult.append("<html><body style='background:#282c34; font-family:monospace; white-space:pre;'>");

        for (Token t : token_list) {
            String color;

            switch(t.getCode()) {
                case TokenCode.INT: color = color_types.get(TokenCode.BLUE); break;
                case TokenCode.ID:  color = color_types.get(TokenCode.GREEN); break;
                case TokenCode.LPAREN:  color = color_types.get(TokenCode.YELLOW); break;
                case TokenCode.RPAREN: color = color_types.get(TokenCode.YELLOW); break;
                case TokenCode.EOF:  color = color_types.get(TokenCode.RED); break;
                default:  color = color_types.get(TokenCode.WHITE); // domyślny biały
            }

            htmlResult.append("<span style='color:").append(color).append(";'>")
                    .append(t.getText())
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
