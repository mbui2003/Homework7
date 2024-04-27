import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    @Test
    public void testDisplay() {
        Font arial = Font.getFont("Arial");
        Color red = Color.getColor("Red");
        Size fontSize12 = Size.getSize(12);
        Character character = new Character('A', arial, red, fontSize12);

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        character.display();

        // Restore normal System.out
        System.setOut(System.out);

        String expectedOutput = "Character: A, Font: Arial, Color: Red, Size: 12\n";
        String actualOutput = outContent.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToString() {
        Font arial = Font.getFont("Arial");
        Color red = Color.getColor("Red");
        Size fontSize12 = Size.getSize(12);
        Character character = new Character('A', arial, red, fontSize12);

        String expectedString = "A, Font: Arial, Color: Red, Size: 12";
        String actualString = character.toString();

        assertEquals(expectedString, actualString);
    }

    @Test
    public void testFromString() {

        Font font = Font.getFont("Arial");
        Color color = Color.getColor("Red");
        Size size = Size.getSize(12);

        Character character1 = new Character('A', font, color, size);
        String characterString = "A, Font: Arial, Color: Red, Size: 12";
        Character character2 = Character.fromString(characterString);

        assertEquals(character1, character2);
    }

    @Test
    public void testEqualsSameInstance() {
        Font arial = Font.getFont("Arial");

        Color red = Color.getColor("Red");

        Size fontSize12 = Size.getSize(12);

        // Test if equals() returns true for two identical characters
        Character character1 = new Character('A', arial, red, fontSize12);
        Character character2 = new Character('A', arial, red, fontSize12);
        assertTrue(character1.equals(character2));
    }

    @Test
    public void testEqualsDifferentInstance() {
        Font arial = Font.getFont("Arial");

        Color red = Color.getColor("Red");

        Size fontSize12 = Size.getSize(12);

        // Test if equals() returns false for two different characters
        Character character1 = new Character('A', arial, red, fontSize12);
        Character character2 = new Character('B', arial, red, fontSize12);
        assertFalse(character1.equals(character2));
    }
}
