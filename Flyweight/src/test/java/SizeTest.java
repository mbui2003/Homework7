import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SizeTest {
    @Test
    public void testGetSizeSameInstance() {
        Size firstFontSize12 = Size.getSize(12);
        Size secondFontSize12 = Size.getSize(12);
        assertEquals(firstFontSize12, secondFontSize12);
    }

    @Test
    public void testGetSizeDifferentInstance() {
        Size fontSize12 = Size.getSize(12);
        Size fontSize14 = Size.getSize(14);
        assertNotEquals(fontSize12, fontSize14);
    }

    @Test
    public void testToString() {
        Size size = Size.getSize(12);

        String expectedString = "Size: 12";
        String actualString = size.toString();

        assertEquals(expectedString, actualString);
    }

}
