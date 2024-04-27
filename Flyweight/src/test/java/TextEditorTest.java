import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {
    private TextEditor textEditor;

    @BeforeEach
    public void setUp() {
        textEditor = new TextEditor();
    }

    @Test
    public void testAddCharacter() {
        Font font = Font.getFont("Arial");
        Color color = Color.getColor("Red");
        Size size = Size.getSize(12);
        Character expectedCharacter = new Character('A', font, color, size);

        textEditor.addCharacter(expectedCharacter);

        Character actualCharacter = textEditor.getCharacters().get(0);

        assertEquals(expectedCharacter, actualCharacter);
    }

    @Test
    public void testEditCharacter() {
        Font font = Font.getFont("Arial");
        Color color = Color.getColor("Red");
        Size size = Size.getSize(12);
        Character character = new Character('A', font, color, size);
        textEditor.addCharacter(character);

        textEditor.editCharacter(0, 'B', font, color, size);

        // Create a new Character object with the edited values
        Character expectedCharacter = new Character('B', font, color, size);

        // Retrieve the character at index 0 from the TextEditor
        Character actualCharacter = textEditor.getCharacters().get(0);

        // Assert that the retrieved character matches the edited character
        assertEquals(expectedCharacter, actualCharacter);
    }


    @Test
    public void testClearDocument() {
        Font font = Font.getFont("Arial");
        Color color = Color.getColor("Red");
        Size size = Size.getSize(12);
        Character character = new Character('A', font, color, size);
        textEditor.addCharacter(character);

        textEditor.clearDocument();

        assertTrue(textEditor.getCharacters().isEmpty());
    }

    @Test
    public void testSaveAndLoadDocument() {
        Font font = Font.getFont("Arial");
        Color color = Color.getColor("Red");
        Size size = Size.getSize(12);
        Character expectedCharacter = new Character('A', font, color, size);
        textEditor.addCharacter(expectedCharacter);

        String fileName = "testDocument.txt";
        textEditor.saveDocumentToFile(fileName);

        TextEditor loadedEditor = TextEditor.loadDocumentFromFile(fileName);

        Character actualCharacter = loadedEditor.getCharacters().get(0);

        assertNotNull(loadedEditor);
        assertEquals(expectedCharacter, loadedEditor.getCharacters().get(0));

        File file = new File(fileName);
        file.delete();
    }
}