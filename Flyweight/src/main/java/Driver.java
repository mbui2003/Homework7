public class Driver {
    public static void main(String[] args) {
        // Define flyweight objects for font, color, and size
        Font arial = Font.getFont("Arial");
        Font calibri = Font.getFont("Calibri");
        Font verdana = Font.getFont("Verdana");
        Font helvetica = Font.getFont("Helvetica");

        Color red = Color.getColor("Red");
        Color blue = Color.getColor("Blue");
        Color black = Color.getColor("Black");
        Color purple = Color.getColor("Purple");

        Size fontSize12 = Size.getSize(12);
        Size fontSize14 = Size.getSize(14);
        Size fontSize16 = Size.getSize(16);
        Size fontSize18 = Size.getSize(18);

        TextEditor textEditor = new TextEditor();

        textEditor.addCharacter(new Character('H', arial, red, fontSize12));
        textEditor.addCharacter(new Character('e', calibri, blue, fontSize14));
        textEditor.addCharacter(new Character('l', verdana, black, fontSize16));
        textEditor.addCharacter(new Character('l', helvetica, purple, fontSize18));
        textEditor.addCharacter(new Character('o', arial, red, fontSize12));
        textEditor.addCharacter(new Character('W', calibri, blue, fontSize14));
        textEditor.addCharacter(new Character('o', verdana, black, fontSize16));
        textEditor.addCharacter(new Character('r', helvetica, purple, fontSize18));
        textEditor.addCharacter(new Character('l', arial, red, fontSize12));
        textEditor.addCharacter(new Character('d', calibri, blue, fontSize14));
        textEditor.addCharacter(new Character('C', verdana, black, fontSize16));
        textEditor.addCharacter(new Character('S', helvetica, purple, fontSize18));
        textEditor.addCharacter(new Character('4', arial, red, fontSize12));
        textEditor.addCharacter(new Character('8', calibri, blue, fontSize14));
        textEditor.addCharacter(new Character('0', verdana, black, fontSize16));
        textEditor.addCharacter(new Character('0', helvetica, purple, fontSize18));

        textEditor.displayDocument();
        System.out.println();

        textEditor.editCharacter(1, '3', calibri, blue, fontSize14);
        System.out.println();

        textEditor.displayDocument();
        System.out.println();


        textEditor.saveDocumentToFile("hello_world.txt");
        System.out.println();


        textEditor.clearDocument();
        System.out.println();


        textEditor.displayDocument();
        System.out.println();


        textEditor = TextEditor.loadDocumentFromFile("hello_world.txt");
        System.out.println();


        textEditor.displayDocument();
    }
}
