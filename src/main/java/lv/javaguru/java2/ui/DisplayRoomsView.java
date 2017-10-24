package lv.javaguru.java2.ui;

import lv.javaguru.java2.Character;
import lv.javaguru.java2.Room;

import java.util.List;
import java.util.Scanner;

public class DisplayRoomsView implements View {
    private List<Room> rooms;

    public DisplayRoomsView(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void execute() {
        System.out.println("Print all Rooms option selected");

        for (Room room : rooms) {
            System.out.println(room.toString());
        }
        System.out.println("Printing all Rooms finished.");
        System.out.println();
    }
}
