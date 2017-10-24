package lv.javaguru.java2.ui;

import lv.javaguru.java2.Character;

import java.util.List;
import java.util.Scanner;

public class CreateCharacterView implements View {

    private List<Character> characters;

    public CreateCharacterView(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public void execute() {
        System.out.println("Create new Character option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Is male? True/False: ");
        boolean isMale = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Enter bio: ");
        String bio = scanner.nextLine();

        ///business logic
        Character character = new Character();
        character.setName(name);
        character.setMale(isMale);
        character.setBio(bio);
        characters.add(character);
        ///end of business logic

        System.out.println("New Character created!");
        System.out.println();
    }
}
