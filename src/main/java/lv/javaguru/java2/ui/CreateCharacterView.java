package lv.javaguru.java2.ui;

import lv.javaguru.java2.businesslogic.CreateCharacterService;
import lv.javaguru.java2.businesslogic.api.CreateCharacterRequest;
import java.util.Scanner;

public class CreateCharacterView implements View {

    private CreateCharacterService createCharService;

    public CreateCharacterView(CreateCharacterService createCharService) {
        this.createCharService = createCharService;
    }

    @Override
    public void execute() {
        System.out.println("Create new Character option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Sex - M/F: ");
        char sex = scanner.nextLine().charAt(0);
        System.out.print("Enter bio: ");
        String bio = scanner.nextLine();


        ///business logic
        createCharService.createCharacter(new CreateCharacterRequest(name, sex, bio));
        //p.s. note: no response for now
        ///end of business logic


        System.out.println("New Character create end");
        System.out.println();
    }
}
