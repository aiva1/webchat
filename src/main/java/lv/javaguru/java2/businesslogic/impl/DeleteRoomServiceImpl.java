package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.domain.Room;
import lv.javaguru.java2.businesslogic.DeleteRoomService;
import lv.javaguru.java2.businesslogic.api.DeleteRoomRequest;
import lv.javaguru.java2.businesslogic.api.DeleteRoomResponse;
import lv.javaguru.java2.database.RoomDAO;

import java.util.Optional;

public class DeleteRoomServiceImpl implements DeleteRoomService {

    private RoomDAO roomDAO;

    public DeleteRoomServiceImpl(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    public DeleteRoomResponse deleteByName(DeleteRoomRequest deleteRequest) {

        Optional<Room> roomOpt = roomDAO.getByName(deleteRequest.getName());

        if (roomOpt.isPresent()) {
            Room room = roomOpt.get();
            roomDAO.delete(room);
            return new DeleteRoomResponse(true);
        }

        return new DeleteRoomResponse(false);
    }
}
