package lv.javaguru.java2.ui;

import lv.javaguru.java2.businesslogic.CreateRoomService;
import lv.javaguru.java2.businesslogic.api.CreateRoomRequest;

import java.util.Scanner;

public class CreateRoomView implements View {


    private CreateRoomService createRoomService;

    public CreateRoomView(CreateRoomService createRoomService) {
        this.createRoomService = createRoomService;
    }

    @Override
    public void execute() {
        System.out.println("Create new Room option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter max capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        //business logic
        createRoomService.createRoom(new CreateRoomRequest(name, capacity, description));
        //note: no response here
        //end of business logic

        System.out.println("New Room create finished");
        System.out.println();
    }
}
