import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextEditor {
    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void editCharacter(int index, char value, Font font, Color color, Size size) {
        if (indexIsInRange(index)) {
            characters.set(index, new Character(value, font, color, size));
            System.out.println("Character at index " + index + " edited successfully.");
        } else {
            System.out.println("Invalid index for character editing.");
        }
    }

    private boolean indexIsInRange(int index) {
        return index >= 0 && index < characters.size();
    }

    public void clearDocument() {
        characters.clear();
        System.out.println("Document cleared.");
    }

    public void saveDocumentToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Character character : characters) {
                writer.println(character.toString());
            }
            System.out.println("Document saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving document to file: " + e.getMessage());
        }
    }

    public static TextEditor loadDocumentFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<Character> characters = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                characters.add(Character.fromString(line));
            }
            System.out.println("Document loaded from file: " + fileName);
            TextEditor editor = new TextEditor();
            editor.characters.addAll(characters);
            return editor;
        } catch (IOException e) {
            System.out.println("Error loading document from file: " + e.getMessage());
            return null;
        }
    }

    public void displayDocument() {
        System.out.println("Document Content:");
        for (Character character : characters) {
            System.out.println(character);
        }
    }

    public List<Character> getCharacters() {
        return characters;
    }
}
