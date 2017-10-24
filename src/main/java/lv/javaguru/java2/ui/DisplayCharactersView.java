package lv.javaguru.java2.ui;

import lv.javaguru.java2.Character;

import java.util.List;

public class DisplayCharactersView implements View {

    private List<Character> characters;

    public DisplayCharactersView(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public void execute() {
        System.out.println("Print all Characters option selected");

        for (Character character : characters) {
            System.out.println(character.toString());
        }
        System.out.println("Printing all Characters finished.");
        System.out.println();
    }
}
