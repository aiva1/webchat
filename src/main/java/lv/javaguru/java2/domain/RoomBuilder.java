package lv.javaguru.java2.domain;

import java.util.List;

public class RoomBuilder {

    private Long id;
    private String name;
    private int capacity;
    private String description;
    private List<String> messages; //TODO replace String with type Message
    private List<Character> characters;

    private RoomBuilder() {}

    public static RoomBuilder createRoom() {
        return new RoomBuilder();
    }

    public static Room createRoom(String name, int capacity, String description) {
        return createRoom()
                .withName(name)
                .withCapacity(capacity)
                .withDescription(description)
                .build();
    }

    public Room build() {
        Room room = new Room();
        room.setId(id);
        room.setName(name);
        room.setCapacity(capacity);
        room.setDescription(description);

        return room;
    }

    public RoomBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public RoomBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public RoomBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public RoomBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
}
