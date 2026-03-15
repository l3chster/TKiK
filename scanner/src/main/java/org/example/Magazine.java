package org.example;
import java.util.ArrayList;

import java.util.ArrayList;

public class Magazine {
    private final ArrayList<Token> _tokens;  // list of tokens

    Magazine() {
        this._tokens = new ArrayList<>();
    };

    public void add_token(Token t) {
        this._tokens.add(t);
    }
    public ArrayList<Token> get_tokens() {
        return this._tokens;
    }
}
