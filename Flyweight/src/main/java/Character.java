import java.util.Objects;

public class Character {
    private final char character;
    private final Font characterFont;
    private final Color characterColor;
    private final Size characterSize;

    public Character(char character, Font characterFont, Color characterColor, Size characterSize) {
        this.character = character;
        this.characterFont = characterFont;
        this.characterColor = characterColor;
        this.characterSize = characterSize;
    }

    public void display() {
        System.out.println("Character: " + character + ", " + characterFont + ", " + characterColor + ", " + characterSize);
    }

    @Override
    public String toString() {
        return character + ", " + characterFont + ", " + characterColor + ", " + characterSize;
    }

    public static Character fromString(String stringToBeConverted) {
        String[] parts = stringToBeConverted.split(", ");
        char value = parts[0].charAt(0);
        Font font = Font.getFont(parts[1].substring(parts[1].indexOf(":") + 2));
        Color color = Color.getColor(parts[2].substring(parts[2].indexOf(":") + 2));
        int size = Integer.parseInt(parts[3].substring(parts[3].indexOf(":") + 2));
        Size fontSize = Size.getSize(size);
        return new Character(value, font, color, fontSize);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Character other = (Character) obj;
        return character == other.character &&
                Objects.equals(characterFont, other.characterFont) &&
                Objects.equals(characterColor, other.characterColor) &&
                Objects.equals(characterSize, other.characterSize);
    }

    public char getCharacter() {
        return character;
    }
}