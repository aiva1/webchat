package lv.javaguru.java2.ui;

import lv.javaguru.java2.domain.Room;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SendMessageToRoomView implements View {

    private List<Room> rooms;

    public SendMessageToRoomView(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void execute() {
        System.out.println("Send Message to Room option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter room name: ");
        final String name = scanner.nextLine();
        System.out.print("Enter message: ");
        String message = scanner.nextLine();
        Optional<Room> foundRoom = rooms.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst();

        if (foundRoom.isPresent()) {
            System.out.println("Specified Room is found, message will be send to it.");
            Room room = foundRoom.get();
            room.addMessage(message);
        }
        else {
            System.out.println("Specified Room was not found.");
        }
        System.out.println("Send Message to Room option finished");
        System.out.println();
    }
}
