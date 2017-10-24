package lv.javaguru.java2.ui;

import lv.javaguru.java2.Character;
import lv.javaguru.java2.Room;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RemoveCharacterFromRoomView implements View {

    private List<Character> characters; //TODO: use Character instead of List. Database will perform search through all entities
    private List<Room> rooms;

    public RemoveCharacterFromRoomView(List<Character> characters, List<Room> rooms) {
        this.characters = characters;
        this.rooms = rooms;
    }

    @Override
    public void execute() {
        System.out.println("Remove Character from Room option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Character name: ");
        String characterName = scanner.nextLine();
        System.out.println("Enter Room name: ");
        String roomName = scanner.nextLine();
        Optional<Character> foundCharacter = characters.stream()
                .filter(ch -> ch.getName().equals(characterName))
                .findFirst();
        Optional<Room> foundRoom = rooms.stream()
                .filter(r -> r.getName().equals(roomName))
                .findFirst();

        if (foundCharacter.isPresent() && foundRoom.isPresent()) {
            System.out.println("Specified Character and Room are found. The Character will be removed from Room.");
            Room room = foundRoom.get();
            Character character = foundCharacter.get();
            room.removeCharacter(character);
        }
        else {
            System.out.println("Specified Character or Room was not found. Removal will not be executed.");
        }
        System.out.println("Remove Character from Room option finished");
        System.out.println();
    }
}
