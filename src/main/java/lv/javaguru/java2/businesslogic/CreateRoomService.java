package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.api.CreateRoomRequest;
import lv.javaguru.java2.businesslogic.api.CreateRoomResponse;

public interface CreateRoomService {

    CreateRoomResponse createRoom(CreateRoomRequest createRequest);
}
