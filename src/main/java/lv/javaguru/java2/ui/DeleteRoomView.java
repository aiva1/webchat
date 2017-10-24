package lv.javaguru.java2.ui;

import lv.javaguru.java2.Room;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DeleteRoomView implements View {
    private List<Room> rooms;

    public DeleteRoomView(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void execute() {
        System.out.println("Delete Room option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter room name: ");
        final String name = scanner.nextLine();
        Optional<Room> foundRoom = rooms.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst();

        if (foundRoom.isPresent()) {
            System.out.println("Specified Room is found and will be deleted.");
            rooms.remove(foundRoom.get());
        }
        else {
            System.out.println("Specified Room was not found.");
        }
        System.out.println("Delete Room option finished");
        System.out.println();
    }
}
