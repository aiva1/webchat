package lv.javaguru.java2.ui;

import lv.javaguru.java2.domain.Character;
import lv.javaguru.java2.domain.Room;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DisplayAllCharactersInRoomView implements View {
    private List<Room> rooms;

    public DisplayAllCharactersInRoomView(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void execute() {
        System.out.println("Print all Characters in Room option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Room name: ");
        String roomName = scanner.nextLine();
        Optional<Room> foundRoom = rooms.stream()
                .filter(r -> r.getName().equals(roomName))
                .findFirst();

        if (foundRoom.isPresent()) {
            System.out.println("Specified Room is found. The contents will be printed to console.");
            Room room = foundRoom.get();
            List<Character> charactersInRoom = room.getCharacters();
            System.out.println("size= "+charactersInRoom.size());
            for (Character c : charactersInRoom) {
                System.out.println(c.toString());
            }
        }
        else {
            System.out.println("Specified Room is NOT found. The contents will not be printed to console.");
        }

        System.out.println("Print all Characters in Room option finished");
        System.out.println();
    }
}
