package lv.javaguru.java2.ui;

import lv.javaguru.java2.Character;
import lv.javaguru.java2.businesslogic.api.DisplayCharactersResponse;
import lv.javaguru.java2.businesslogic.DisplayCharactersService;

public class DisplayCharactersView implements View {

    //private List<Character> characters;
    private DisplayCharactersService displayCharsService;

    public DisplayCharactersView(DisplayCharactersService displayCharsService) {
        this.displayCharsService = displayCharsService;
    }

    @Override
    public void execute() {
        System.out.println("Print all Characters option selected");

        ///business logic
        DisplayCharactersResponse response = displayCharsService.getCharacters();
        ///end of business logic

        for (Character character : response.getCharacters()) {
            System.out.println(character.toString());
        }
        System.out.println("Printing all Characters finished.");
        System.out.println();
    }
}
