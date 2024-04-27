import java.util.HashMap;
import java.util.Map;

public class Font {
    private final String fontName;
    private static final Map<String, Font> fontFlyweights = new HashMap<>();

    private Font(String fontName) {
        this.fontName = fontName;
    }

    public static Font getFont(String fontName) {
        if(fontDoesNotExist(fontName)) {
            fontFlyweights.put(fontName, new Font(fontName));
        }
        return fontFlyweights.get(fontName);
    }

    private static boolean fontDoesNotExist(String fontName) {
        return !fontFlyweights.containsKey(fontName);
    }

    @Override
    public String toString() {
        return "Font: " + fontName;
    }
}