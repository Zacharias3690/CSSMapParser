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

    public Node find(String selector) {
        for(int i = 0 ; i < this.children.size(); i++) {
            if(this.children.get(i).selector.equals(selector)) {
                return this.children.get(i);
            }
        }

        return null;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Selector: " + this.selector + " Content: " + this.content);
        if(this.children.size() > 0) {
            sb.append("\nChildren: \n");
            for(int i = 0; i < this.children.size(); i++) {
                sb.append(this.children.get(i).toString() + "\n");
            }
        }

        return sb.toString();
    }
}
