package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.DisplayRoomsService;
import lv.javaguru.java2.businesslogic.api.DisplayRoomsResponse;
import lv.javaguru.java2.database.RoomDAO;

public class DisplayRoomServiceImpl implements DisplayRoomsService {

    private RoomDAO roomDAO;

    public DisplayRoomServiceImpl(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    public DisplayRoomsResponse getRooms() {
        return new DisplayRoomsResponse(roomDAO.getAll());
    }
}
