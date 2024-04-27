import java.util.HashMap;
import java.util.Map;

public class Color {
    private final String colorName;
    private static final Map<String, Color> colorFlyweights = new HashMap<>();

    private Color(String colorName) {
        this.colorName = colorName;
    }

    public static Color getColor(String colorName) {
        if(colorDoesNotExist(colorName)) {
            colorFlyweights.put(colorName, new Color(colorName));
        }
        return colorFlyweights.get(colorName);
    }

    private static boolean colorDoesNotExist(String colorName) {
        return !colorFlyweights.containsKey(colorName);
    }

    @Override
    public String toString() {
        return "Color: " + colorName;
    }
}