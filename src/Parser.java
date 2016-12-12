import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Zach on 12/2/2016.
 */
public class Parser {

    public static void parse(LinkedList<Token> tokens) {
        ArrayList<Node> tree = new ArrayList<Node>();

        while(true) {
            if(tokens.size() == 0) break;
            tree.add(Parser.parseToken(tokens));
        }

        for(int i = 0; i < tree.size(); i++) {
            System.out.println(tree.get(i).toString());
        }
    }

    private static Node parseToken(LinkedList<Token> tokens) {
        String content, selector;

        while(tokens.peek().tag.equals("WHITESPACE")) { tokens.poll(); }

        selector = Parser.parseSelector(tokens);
        content = Parser.parseContent(tokens);

        return new Node(selector, content);
    }

    private static String parseSelector(LinkedList<Token> tokens) {
        StringBuilder sb = new StringBuilder();

        while(true) {
            if(tokens.peek() == null || tokens.peek().content.equals("{")) {
                break;
            }

            sb.append(tokens.poll().content);
        }

        return sb.toString();
    }

    private static String parseContent(LinkedList<Token> tokens) {
        StringBuilder sb = new StringBuilder();
        Token next = tokens.poll();

        if(next == null || !next.content.equals("{")) {
            return "";
        }

        while(tokens.peek() != null && !(next = tokens.poll()).content.equals("}")) {
            if(next.tag.equals("WHITESPACE")) continue;
            sb.append(next.content);
        }

        return sb.toString();
    }
}
