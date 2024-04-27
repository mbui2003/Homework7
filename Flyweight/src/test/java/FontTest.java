import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FontTest {
    @Test
    public void testGetFontSameInstance() {
        Font arial1 = Font.getFont("Arial");
        Font arial2 = Font.getFont("Arial");

        assertEquals(arial1, arial2);
    }

    @Test
    public void testGetFontDifferentInstance() {
        Font arial = Font.getFont("Arial");
        Font calibri = Font.getFont("Calibri");

        assertNotEquals(arial, calibri);
    }

    @Test
    public void testToString() {
        Font arial = Font.getFont("Arial");

        String expectedString = "Font: Arial";
        String actualString = arial.toString();

        assertEquals(expectedString, actualString);
    }
}