package lv.javaguru.java2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ChatApplication {

    public static void main(String[] args) {
        //Program Menu/Use cases:
        //1. Create new Character
        //2. Create new Room
        //3. Add Character to Room
        //4. Send message to Room
        //5. View all messages previously sent to Room
        //6. Print all Characters to console
        //7. Print all Rooms to console
        //8. Print all characters in Room
        //9. Remove Character from Room
        //10. Delete Character
        //11. Delete Room
        //12. Exit

        List<Character> characters = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();

        while (true) {
            printMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 12) {
                break;
            }
            switch (menuItem) {
                case 1: {
                    createNewCharacter(characters);
                    break;
                }
                case 2: {
                    createNewRoom(rooms);
                    break;
                }
                case 3: {
                    addCharacterToRoom(characters, rooms);
                    break;
                }
                case 4: {
                    //TODO: consider sending message from specific Character to specific Room
                    sendMessageToRoom(rooms);
                    break;
                }
                case 5: {
                    displayAllMessagesInRoom(rooms);
                    break;
                }
                case 6: {
                    printAllCharactersToConsole(characters);
                    break;
                }
                case 7: {
                    printAllRoomsToConsole(rooms);
                    break;
                }
                case 8: {
                    printAllCharactersInRoom(rooms);
                    break;
                }
                case 9: {
                    removeCharacterFromRoom(characters, rooms);
                    break;
                }
                case 10: {
                    deleteCharacter(characters);
                    break;
                }
                case 11: {
                    deleteRoom(rooms);
                    break;
                }
            }
        }
    }


    private static void createNewCharacter(List<Character> characters) {
        System.out.println("Create new Character option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Is male? True/False: ");
        boolean isMale = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Enter bio: ");
        String bio = scanner.nextLine();
        Character character = new Character();
        character.setName(name);
        character.setMale(isMale);
        character.setBio(bio);
        characters.add(character);
        System.out.println("New Character created!");
        System.out.println();
    }

    private static void createNewRoom(List<Room> rooms) {
        System.out.println("Create new Room option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter max capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        Room room = new Room();
        room.setName(name);
        room.setCapacity(capacity);
        room.setDescription(description);
        rooms.add(room);

        System.out.println("New Room created!");
        System.out.println();
    }

    private static void addCharacterToRoom(List<Character> characters, List<Room> rooms) {
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

    private static void sendMessageToRoom(List<Room> rooms) {
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

    private static void displayAllMessagesInRoom(List<Room> rooms) {
        System.out.println("Send Message to Room option selected");

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
        System.out.println("Send Message to Room option finished.");
        System.out.println();
    }

    private static void removeCharacterFromRoom(List<Character> characters, List<Room> rooms) {
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

    private static void deleteCharacter(List<Character> characters) {
        System.out.println("Delete Character option selected");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter character name: ");
        final String name = scanner.nextLine();
        Optional<Character> foundCharacter = characters.stream()
                .filter(ch -> ch.getName().equals(name))
                .findFirst();
        if (foundCharacter.isPresent()) {
            System.out.println("Specified Character is found. The Character will be deleted.");
            characters.remove(foundCharacter.get());
        }
        else {
            System.out.println("Specified Character was not found.");
        }
        System.out.println("Delete Character option finished");
        System.out.println();

        //TODO Character should be deleted from all rooms
    }

    private static void deleteRoom(List<Room> rooms) {
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

    private static void printAllCharactersToConsole(List<Character> characters) {
        System.out.println("Print all Characters option selected");

        for (Character character : characters) {
            System.out.println(character.toString());
        }
        System.out.println("Printing all Characters finished.");
        System.out.println();
    }

    private static void printAllRoomsToConsole(List<Room> rooms) {
        System.out.println("Print all Rooms option selected");

        for (Room room : rooms) {
            System.out.println(room.toString());
        }
        System.out.println("Printing all Rooms finished.");
        System.out.println();
    }

    private static void printAllCharactersInRoom(List<Room> rooms) {
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

    private static void printMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Create new Character");
        System.out.println("2. Create new Room");
        System.out.println("3. Add Character to Room");
        System.out.println("4. Send message to Room");
        System.out.println("5. View all messages previously sent to Room");
        System.out.println("6. Print all Characters to console");
        System.out.println("7. Print all Rooms to console");
        System.out.println("8. Print all Characters in specified Room");
        System.out.println("9. Remove Character from Room");
        System.out.println("10. Delete Character");
        System.out.println("11. Delete Room");
        System.out.println("12. Exit");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }



}