package org.example;


public class Main {
    public static void main(String[] args) {
            if (args.length == 0) {
                System.err.println("Podaj wyrażenie matematyczne jako argument!");
                return;
            }

            String expression = String.join(" ", args);

            System.out.println("Skanuję wyrażenie: " + expression);

            Scanner scanner = new Scanner(expression);
            try{
                scanner.scanTokens();
                scanner.listTokens();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
}
