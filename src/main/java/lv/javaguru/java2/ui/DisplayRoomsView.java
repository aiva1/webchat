package lv.javaguru.java2.ui;

import lv.javaguru.java2.Character;
import lv.javaguru.java2.Room;
import lv.javaguru.java2.businesslogic.DisplayRoomsService;
import lv.javaguru.java2.businesslogic.api.DisplayRoomsResponse;

import java.util.List;
import java.util.Scanner;

public class DisplayRoomsView implements View {

    private DisplayRoomsService displayService;

    public DisplayRoomsView(DisplayRoomsService displayService) {
        this.displayService = displayService;
    }

    @Override
    public void execute() {
        System.out.println("Print all Rooms option selected");

        ///business logic
        DisplayRoomsResponse response = displayService.getRooms();
        //end of business logic

        for (Room room : response.getRooms()) {
            System.out.println(room.toString());
        }
        System.out.println("Printing all Rooms finished.");
        System.out.println();
    }
}
