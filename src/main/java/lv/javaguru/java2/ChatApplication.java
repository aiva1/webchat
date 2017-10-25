package lv.javaguru.java2;

import lv.javaguru.java2.businesslogic.*;
import lv.javaguru.java2.businesslogic.impl.*;
import lv.javaguru.java2.database.temp.InMemoryCharacterDB;
import lv.javaguru.java2.database.temp.InMemoryRoomDB;
import lv.javaguru.java2.ui.*;

import java.util.*;

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

        InMemoryCharacterDB characterDB = new InMemoryCharacterDB();
        InMemoryRoomDB roomDB = new InMemoryRoomDB();

        CreateCharacterService createCharacterService = new CreateCharacterServiceImpl(characterDB);
        DisplayCharactersService displayCharactersService = new DisplayCharactersServiceImpl(characterDB);
        DeleteCharacterService deleteCharacterService = new DeleteCharacterServiceImpl(characterDB);

        CreateRoomService createRoomService = new CreateRoomServiceImpl(roomDB);
        DisplayRoomsService displayRoomsService = new DisplayRoomServiceImpl(roomDB);
        DeleteRoomService deleteRoomService = new DeleteRoomServiceImpl(roomDB);



        List<Character> characters = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();

        Map<Integer, View> commands = new HashMap<>();
        commands.put(1, new CreateCharacterView(createCharacterService));
        commands.put(2, new CreateRoomView(createRoomService));
        //commands.put(3, new AddCharacterToRoomView(characters, rooms)); //TODO: consider using Character instead of whole list
        //commands.put(4, new SendMessageToRoomView(rooms)); //TODO: consider sending message from specific Character to specific Room
        //commands.put(5, new DisplayAllMessagesInRoomView(rooms)); //TODO: consider using Room instead of list
        commands.put(6, new DisplayCharactersView(displayCharactersService));
        commands.put(7, new DisplayRoomsView(displayRoomsService));
        //commands.put(8, new DisplayAllCharactersInRoomView(rooms));
        //commands.put(9, new RemoveCharacterFromRoomView(characters, rooms));
        commands.put(10, new DeleteCharacterView(deleteCharacterService));
        commands.put(11, new DeleteRoomView(deleteRoomService));

        while (true) {
            printMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 12) {
                break;
            }

            View view = commands.get(menuItem);
            view.execute();
        }
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