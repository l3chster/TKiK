## Zadanie_1 (scanner_1_part)

- Skanujemy wyrażenie matematyczne, np. 2+3*(76+8/3) + 3*(9-3)
- Określ zbiór tokenów do skanowania (nazwa/kod i opis) i język implementacji
- Napisz program rozpoznający i wypisujący tokeny - pary: (kod, wartość) 
   - funkcja skaner wywoływana w pętli do napotkania końca wyrażenia
   - rozpoznawane tokeny: liczba całkowita, identyfikator, działania '+,-,*,/', nawiasy '(,)'
- Uzupełnij powyższy program o:
   - obsługę błędów skanera, w tym odpowiednie komentarze
   - lokalizację błędu, tu: numer kolumny gdzie rozpoczyna się błędny token
   - pomijanie spacji i innych białych znaków pomiędzy tokenami, jako pierwszy etap skanowania

## Zadanie_2 (colorful_scanner)

Zadania
- Przygotuj tabelę tokenów własnego formatu.
- Bazując na przygotowanym własnym formacie np. na uproszczonym języku programowania, napisz program kolorujący składnię. Zaimplementuj i wykorzystaj skaner rozpoznający tokeny wg przygotowanej tabeli tokenów. Program powinien wczytywać z pliku kod w wybranym formacie i zwrócić do innego pliku pokolorowany kod. Jako formatu wyjściowego można wykorzystać np. HTML. W pliku wyjściowym powinien być zachowany układ tekstu z pliku wejściowego.
