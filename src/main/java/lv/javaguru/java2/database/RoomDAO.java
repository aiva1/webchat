package lv.javaguru.java2.database;

import lv.javaguru.java2.Room;

import java.util.List;
import java.util.Optional;

public interface RoomDAO {

    Room save(Room room);

    Optional<Room> getByName(String name);

    void delete(Room room);

    List<Room> getAll();
}
