import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zach on 11/28/2016.
 */
public class Node {
    public String selector;
    public String content;
    private ArrayList<Node> children;

    public Node(String selector, String content, ArrayList<Node> children) {
        if(children != null) {
            this.children = children;
        } else {
            this.children = new ArrayList<Node>();
        }

        this.content = content;
        this.selector = selector;
    }

    public Node(String selector, String content) {
        this(selector, content, null);
    }

    public Node(String selector) {
        this(selector, "", null);
    }

    public Node() {
        this("", "", null);
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public ArrayList<Node> getChidlren() {
        return children;
    }

    public String toString() {
        return "Selector: " + this.selector + " Content: " + this.content + " Children: " + this.children.size();
    }
}
