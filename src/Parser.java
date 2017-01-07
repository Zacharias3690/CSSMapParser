import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Zach on 12/2/2016.
 */
public class Parser {

    public static Node parse(LinkedList<Token> tokens) {
        Node root = new Node();

        while(true) {
            if(tokens.size() == 0) break;
            Parser.parseToken(tokens, root);
        }

        return root;
    }

    private static Node parseToken(LinkedList<Token> tokens, Node root) {
        Node tree;

        while(tokens.peek().tag.equals("WHITESPACE")) { tokens.poll(); }

        tree = Parser.parseSelector(tokens, root);
        tree.content = Parser.parseContent(tokens);

        return tree;
    }

    private static Node parseSelector(LinkedList<Token> tokens, Node tree) {
        Token next;
        Node nextNode;

        while(true) {
            if (tokens.peek() == null || tokens.peek().content.equals("{")) {
                break;
            }

            next = tokens.poll();

            if(next.tag.equals("WHITESPACE")) continue;

            if(next.content.equals("{")) break;

            nextNode = tree.find(next.content);

            if(nextNode == null) {
                nextNode = new Node(next.content);
                tree.addChild(nextNode);
                tree = nextNode;
            }
        }

        return tree;
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
