package lv.javaguru.java2.ui;

import lv.javaguru.java2.Character;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DeleteCharacterView implements View {
    private List<Character> characters;

    public DeleteCharacterView(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public void execute() {
        System.out.println("Delete Character option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter character name: ");
        final String name = scanner.nextLine();
        Optional<Character> foundCharacter = characters.stream()
                .filter(ch -> ch.getName().equals(name))
                .findFirst();
        if (foundCharacter.isPresent()) {
            System.out.println("Specified Character is found. The Character will be deleted.");
            characters.remove(foundCharacter.get());
        }
        else {
            System.out.println("Specified Character was not found.");
        }
        System.out.println("Delete Character option finished");
        System.out.println();

        //TODO Character should be deleted from all rooms
    }
}
