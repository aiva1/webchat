package lv.javaguru.java2.ui;

import lv.javaguru.java2.Character;
import lv.javaguru.java2.Room;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AddCharacterToRoomView implements View {

    private List<Character> characters;
    private List<Room> rooms;


    public AddCharacterToRoomView(List<Character> characters, List<Room> rooms) {
        this.characters = characters;
        this.rooms = rooms;
    }

    @Override
    public void execute() {
        System.out.println("Add Character to Room option selected");

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
            System.out.println("Specified Character and Room are found. The Character will be added to Room.");
            Room room = foundRoom.get();
            Character character = foundCharacter.get();
            room.addCharacter(character);
        }
        else {
            System.out.println("Specified Character or Room was not found. Adding will not be executed.");
        }
        System.out.println("Add Character from Room option finished");
    }
}
