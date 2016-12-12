/**
 * Created by Zach on 11/30/2016.
 */
public class Token {
    public String content;
    public String tag;

    public Token(String content, String tag) {
        this.content = content;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Content: " + content + " Tag: " + tag;
    }
}
