package lv.javaguru.java2.ui;

import lv.javaguru.java2.Room;

import java.util.List;
import java.util.Scanner;

public class CreateRoomView implements View {

    private List<Room> rooms;

    public CreateRoomView(List<Room> rooms) {
        this.rooms = rooms;
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
        Room room = new Room();
        room.setName(name);
        room.setCapacity(capacity);
        room.setDescription(description);
        rooms.add(room);
        //end of business logic

        System.out.println("New Room created!");
        System.out.println();
    }
}
