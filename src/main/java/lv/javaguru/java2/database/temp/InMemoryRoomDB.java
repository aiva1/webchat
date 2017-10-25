package lv.javaguru.java2.database.temp;

import lv.javaguru.java2.Character;
import lv.javaguru.java2.Room;
import lv.javaguru.java2.database.RoomDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryRoomDB implements RoomDAO {

    private List<Room> rooms;

    public InMemoryRoomDB() {
        rooms = new ArrayList<>();
    }

    @Override
    public Room save(Room room) {
        rooms.add(room);
        return room;
    }

    @Override
    public Optional<Room> getByName(String name) {
        Room toReturn = null;
        Optional<Room> foundRoom = rooms.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst();
        if (foundRoom.isPresent()) {
            toReturn = foundRoom.get();
        }
        return Optional.ofNullable(toReturn);
    }

    @Override
    public void delete(Room room) {
        Optional<Room> foundRoom = rooms.stream()
                .filter(r -> r.getName().equals(room.getName()))
                .findFirst();

        if (foundRoom.isPresent()) {
            rooms.remove(foundRoom.get());
        }
    }

    @Override
    public List<Room> getAll() {
        return rooms;
    }
}
