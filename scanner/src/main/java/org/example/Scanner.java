package org.example;
import java.util.*;
import java.lang.*;

public class Scanner {

    private String text;
    private int iterator;
    private String token_value;
    private Magazine magazine;

    public Scanner(String text) {
        this.text = text;
        this.iterator = 0;
        this.token_value = "";
        this.magazine = new Magazine();
    }

    public void execute()  {

        while(this.iterator < this.text.length() )   // zmienić warunek żeby aż znajdzie eof??? zeby nie wykorzystywac dlugosci slowa
        {                                              // EDIT:: w javie nie ma EOF chb musi tak zostac
            char sign = this.text.charAt(this.iterator);

            if (Character.isDigit(sign))
            {
                token_value += sign;
                this.iterator++;

                while( iterator < this.text.length()){
                    sign = this.text.charAt(this.iterator);

                    if (!Character.isDigit(sign))
                        break;

                    token_value += sign;
                    this.iterator++;

                }
                var num_token = new Token(TokenCode.INT,  token_value);
                magazine.add_token(num_token);
                token_value = "";
            }

            this.iterator++;
        }

        for(Token token: magazine.get_tokens())
        {
            System.out.println(token);
            System.out.println();
        }



    }

}
