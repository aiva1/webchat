package lv.javaguru.java2.businesslogic.api;

public class CreateRoomRequest {

    private String name;
    private int capacity;
    private String description;

    public CreateRoomRequest(String name, int capacity, String description) {
        this.name = name;
        this.capacity = capacity;
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
}
