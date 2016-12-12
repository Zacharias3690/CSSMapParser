import java.util.ArrayList;

/**
 * Created by Zach on 11/28/2016.
 */
public class CssModifier {
    public ArrayList<CssChild> children;
    public String content;

    public CssModifier(String content) {
        this(content, null);
    }

    public CssModifier(String content, ArrayList<CssChild> children) {
        this.content = content;
        this.children = children != null ? children : new ArrayList<CssChild>();
    }
}
