import java.util.ArrayList;

/**
 * Created by Zach on 11/28/2016.
 */
public class Component {
    public String content;
    public ArrayList<CssModifier> modifiers;
    public ArrayList<CssChild> children;

    public Component(String content) {
        this(content, null);
    }

    public Component(String content, ArrayList<CssChild> children) {
        this.content = content;
        this.children = children != null ? children : new ArrayList<CssChild>();
    }

    public void addModifier(CssModifier modifier) {
        modifiers.add(modifier);
    }
}
