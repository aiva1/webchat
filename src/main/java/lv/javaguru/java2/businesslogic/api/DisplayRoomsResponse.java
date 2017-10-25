package lv.javaguru.java2.businesslogic.api;

import lv.javaguru.java2.Room;

import java.util.List;

public class DisplayRoomsResponse {

    private List<Room> rooms;

    public DisplayRoomsResponse(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
