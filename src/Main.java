import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * Created by Zach on 11/28/2016.
 */
public class Main {
    public static void main(String[] argv) throws IOException {
        final String RESERVED = "RESERVED";
        final String INT = "INTEGER";
        final String ID = "IDENTIFIER";
        final String WHITESPACE = "WHITESPACE";

        LinkedList<Token> tokens;


        TokenExpression[] tokenExpressions = {
                new TokenExpression("\\\\\\[^\\n]+", null), //single line comment
                new TokenExpression("\\/\\*.*\\*\\/", null),  //multi-line comment

                new TokenExpression("[\\s\\n\\t]+", WHITESPACE),  //white space
                new TokenExpression("\\,", RESERVED),
                new TokenExpression(":", RESERVED),
                new TokenExpression(";", RESERVED),
                new TokenExpression("#", RESERVED),
                new TokenExpression("\\*", RESERVED),
                new TokenExpression("\\[", RESERVED),
                new TokenExpression("\\]", RESERVED),
                new TokenExpression("\\(", RESERVED),
                new TokenExpression("\\)", RESERVED),
                new TokenExpression("\\{", RESERVED),
                new TokenExpression("\\}", RESERVED),
                new TokenExpression("\\^", RESERVED),
                new TokenExpression(">", RESERVED),
                new TokenExpression("=", RESERVED),
                new TokenExpression("\"", RESERVED),
                new TokenExpression("\'", RESERVED),
                new TokenExpression("@media", RESERVED),
                new TokenExpression("and", RESERVED),

                new TokenExpression("-?[0-9]*\\.?[0-9]+[px|rem|em|vh|vw|%|s|ms]?", INT),
                new TokenExpression("[\\.|#|^|~]?[A-Za-z][A-Za-z0-9\\-_]*", ID)
        };

        String fileContent = new String(Files.readAllBytes(Paths.get("test.css")));

        tokens = Lexer.lex(fileContent, tokenExpressions);

        Node tree = Parser.parse(tokens);
        System.out.println(tree.toString());
    }
}
