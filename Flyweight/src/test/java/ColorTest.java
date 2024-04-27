import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ColorTest {
    @Test
    public void testGetColorSameInstance() {
        Color red1 = Color.getColor("Red");
        Color red2 = Color.getColor("Red");

        assertEquals(red1, red2);
    }

    @Test
    public void testGetColorDifferentInstance() {
        Color red = Color.getColor("Red");
        Color blue = Color.getColor("Blue");

        assertNotEquals(red, blue);
    }

    @Test
    public void testToString() {
        Color color = Color.getColor("Red");

        String expectedString = "Color: Red";
        String actualString = color.toString();

        assertEquals(expectedString, actualString);
    }
}
