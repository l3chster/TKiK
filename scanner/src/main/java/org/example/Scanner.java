package org.example;

import java.util.ArrayList;

public class Scanner {

    private ArrayList<Token> tokens;
    private String text;
    private int index = 0;

    public Scanner(String text){
        this.text = text;
        tokens = new ArrayList<>();
    }

    public void scanTokens() throws Exception {

        while(index < text.length())
        {
            char sign = text.charAt(index);
            String tokenText =Character.toString(sign);
            switch (sign){
                case '(' : tokens.add(new Token(TokenCode.LPAREN,tokenText));index++;continue;
                case ')': tokens.add(new Token(TokenCode.RPAREN,tokenText));index++;continue;
                case '+': tokens.add(new Token(TokenCode.PLUS,tokenText)); index++;continue;
                case '-': tokens.add(new Token(TokenCode.MINUS,tokenText)); index++;continue;
                case '*': tokens.add(new Token(TokenCode.MUL,tokenText)); index++;continue;
                case '/': tokens.add(new Token(TokenCode.DIV,tokenText)); index++;continue;
            }
            if(Character.isWhitespace(sign))
            {
                index++;
            }
            else if (Character.isDigit(sign))
            {
                handleNumber(text);
            }
            else {
                throw new Exception("Sign is not valid in this language: " + sign);
            }
        }
    }
    private void  handleNumber(String text){
        StringBuilder tokenValue = new StringBuilder();

        while(index < text.length() && Character.isDigit(text.charAt(index))){
            tokenValue.append(text.charAt(index));
            index++;
        }
        tokens.add(new Token(TokenCode.INT,tokenValue.toString()));
    }

    public void listTokens(){
        for(Token token : tokens){
            System.out.println(token);
        }
    }
}
