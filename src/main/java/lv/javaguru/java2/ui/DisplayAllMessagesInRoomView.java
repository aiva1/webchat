package lv.javaguru.java2.ui;

import lv.javaguru.java2.Room;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DisplayAllMessagesInRoomView implements View {

    private List<Room> rooms;

    public DisplayAllMessagesInRoomView(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void execute() {
        System.out.println("Display all messages in Room option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter room name: ");
        final String name = scanner.nextLine();
        Optional<Room> foundRoom = rooms.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst();

        if (foundRoom.isPresent()) {
            System.out.println("Specified Room is found, all messages will be displayed");
            Room room = foundRoom.get();
            List<String> allMessages = room.getMessages();
            for (String message : allMessages) {
                System.out.println(message);
            }
        }
        else {
            System.out.println("Specified Room was not found.");
        }
        System.out.println("Display all Messages in Room option finished.");
        System.out.println();
    }
}
