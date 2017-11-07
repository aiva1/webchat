package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.domain.Room;
import lv.javaguru.java2.businesslogic.CreateRoomService;
import lv.javaguru.java2.businesslogic.api.CreateRoomRequest;
import lv.javaguru.java2.businesslogic.api.CreateRoomResponse;
import lv.javaguru.java2.database.RoomDAO;

public class CreateRoomServiceImpl implements CreateRoomService {

    private RoomDAO roomDAO;

    public CreateRoomServiceImpl(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    public CreateRoomResponse createRoom(CreateRoomRequest createRequest) {
        Room room = new Room();
        room.setName(createRequest.getName());
        room.setCapacity(createRequest.getCapacity());
        room.setDescription(createRequest.getDescription());

        roomDAO.save(room);

        return new CreateRoomResponse(true);
    }
}
