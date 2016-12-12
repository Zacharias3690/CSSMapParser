import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zach on 11/30/2016.
 */

public class Lexer {
    public static LinkedList<Token> lex(String text, TokenExpression[] tokenExpressions) {
        LinkedList<Token> tokens = new LinkedList<Token>();
        int pos = 0;


        while(pos < text.length()) {
            boolean matchFound = false;

            for(int i = 0; i < tokenExpressions.length; i++) {
                Pattern p = Pattern.compile(tokenExpressions[i].expression, Pattern.DOTALL);
                Matcher m = p.matcher(text);
                m = m.region(pos, text.length());
                if(m.lookingAt()) {
                    matchFound = true;
                    String content = m.group(0);

                    if(tokenExpressions[i].group != null) {
                        Token token = new Token(content, tokenExpressions[i].group);
                        tokens.add(token);
                    }

                    pos = m.end(0);
                    break;
                }
            }

            if(!matchFound) {
                throw new Error("Illegal character: " + text.charAt(pos) + "\n" + text.substring(Math.max(pos - 50, 0), Math.min(pos + 50, text.length())) + ")");
            }
        }

        return tokens;
    }
}
