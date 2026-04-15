# 🎨 Colorful Token Scanner

A simple lexical scanner written in Java that analyzes a given expression, recognizes tokens and generates a colorful HTML file with syntax highlighting.

## 🚀 How to run

```bash
mvn compile exec:java "-Dexec.mainClass=org.example.Main" "-Dexec.args=while if  5 == 5 _variable //comment"
```

After running, a file called `kolorowy_skaner.html` will appear in the project directory — open it in your browser to see the colored syntax.

## 📁 Project structure

```
src/
└── main/
    └── java/
        └── org/example/
            ├── Main.java          # entry point, runs the scanner
            ├── Scanner.java       # scans the input and produces tokens
            ├── Token.java         # class representing a single token
            ├── TokenCode.java     # enum with all token types
            └── TokenColors.java   # generates the colorful HTML file
```

## 🔤 Supported tokens

| Token | Character / Word | Description | Color in HTML |
|---|---|---|---------------|
| `INT` | `0`–`9` | Integer number | Bright blue   |
| `ID` | `abc`, `my_variable` | Identifier | Green         |
| `IF` | `if` | Keyword | Yellow        |
| `ELSE` | `else` | Keyword | Yellow        |
| `WHILE` | `while` | Keyword | Yellow        |
| `FOR` | `for` | Keyword | Yellow        |
| `PLUS` | `+` | Addition | White         |
| `MINUS` | `-` | Subtraction | White         |
| `MUL` | `*` | Multiplication | White         |
| `DIV` | `/` | Division | White         |
| `MOD` | `%` | Modulo | White         |
| `ASSIGN` | `=` | Assignment | Cyan          |
| `EQUALS` | `==` | Equality check | Cyan          |
| `LT` | `<` | Less than | Light red     |
| `GT` | `>` | Greater than | Light red     |
| `LPAREN` | `(` | Opening parenthesis | Magenta       |
| `RPAREN` | `)` | Closing parenthesis | Magenta       |
| `LBRACE` | `{` | Opening brace | Bright yellow |
| `RBRACE` | `}` | Closing brace | Bright yellow  |
| `SEMICOLON` | `;` | Semicolon | Grey          |
| `COMMENT` | `//` | Single-line comment | Light green   |
| `EOF` | — | End of input | Red           |

## ⚠️ Error handling

If the scanner encounters an unknown character (e.g. `@`, `#`, `?`), it immediately stops scanning and adds an `EOF` token. Tokens found before the error are kept and colored normally.

```
Nieznany znak: @ — przerywam skanowanie.
```
