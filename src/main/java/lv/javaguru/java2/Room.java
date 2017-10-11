package lv.javaguru.java2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Room {

    private String name;
    private int capacity;
    private String description;
    private List<String> messages; //TODO replace String with type Message
    private List<Character> characters;

    public Room() {
        messages = new LinkedList<>();
        characters = new ArrayList<>();
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void removeCharacter(Character character) {
        for(Character c : characters) {
            if (c.equals(character)) {
                characters.remove(c);
                break;
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getMessages() {
        return messages;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    @Override
    public String toString() {
        return "Room{"+
                "name= " + name + ", capacity= " + capacity + ", description= " + description +
                "}";
    }
}