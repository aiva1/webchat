package lv.javaguru.java2.ui;

import lv.javaguru.java2.businesslogic.DeleteCharacterService;
import lv.javaguru.java2.businesslogic.api.DeleteCharacterRequest;
import lv.javaguru.java2.businesslogic.api.DeleteCharacterResponse;

import java.util.Scanner;

public class DeleteCharacterView implements View {

    private DeleteCharacterService deleteCharService;

    public DeleteCharacterView(DeleteCharacterService deleteCharService) {
        this.deleteCharService = deleteCharService;
    }

    @Override
    public void execute() {
        System.out.println("Delete Character option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter character name: ");
        final String name = scanner.nextLine();

        ///business logic
        DeleteCharacterResponse response = deleteCharService.deleteByName(new DeleteCharacterRequest(name));
        ///end of bl

        if (response.isDeleted()) {
            System.out.println("Specified Character is found. The Character will be deleted.");
        }
        else {
            System.out.println("Specified Character was not found.");
        }

        System.out.println("Delete Character option finished");
        System.out.println();

        //TODO Character should be deleted from all rooms - database will ensure that(?)
    }
}
