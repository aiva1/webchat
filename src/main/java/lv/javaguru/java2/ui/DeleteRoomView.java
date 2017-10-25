package lv.javaguru.java2.ui;

import lv.javaguru.java2.businesslogic.DeleteRoomService;
import lv.javaguru.java2.businesslogic.api.DeleteRoomRequest;
import lv.javaguru.java2.businesslogic.api.DeleteRoomResponse;

import java.util.Scanner;

public class DeleteRoomView implements View {

    private DeleteRoomService deleteRoomService;

    public DeleteRoomView(DeleteRoomService deleteRoomService) {
        this.deleteRoomService = deleteRoomService;
    }

    @Override
    public void execute() {
        System.out.println("Delete Room option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter room name: ");
        final String name = scanner.nextLine();

        ///business logic
        DeleteRoomResponse response = deleteRoomService.deleteByName(new DeleteRoomRequest(name));
        ///end of business logic

        if (response.isRemoved()) {
            System.out.println("Specified Room is found and will be deleted.");
        }
        else {
            System.out.println("Specified Room was not found.");
        }

        System.out.println("Delete Room option finished");
        System.out.println();
    }
}
