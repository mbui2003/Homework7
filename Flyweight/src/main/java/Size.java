import java.util.HashMap;
import java.util.Map;

public class Size {
    private final int sizeValue;
    private static final Map<Integer, Size> sizeFlyweights = new HashMap<>();

    private Size(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public static Size getSize(int sizeValue) {
        if(sizeDoesNotExist(sizeValue)) {
            sizeFlyweights.put(sizeValue, new Size(sizeValue));
        }
        return sizeFlyweights.get(sizeValue);
    }

    private static boolean sizeDoesNotExist(int sizeValue) {
        return !sizeFlyweights.containsKey(sizeValue);
    }

    @Override
    public String toString() {
        return "Size: " + sizeValue;
    }
}