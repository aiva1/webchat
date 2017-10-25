package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.api.DeleteRoomRequest;
import lv.javaguru.java2.businesslogic.api.DeleteRoomResponse;

public interface DeleteRoomService {

    DeleteRoomResponse deleteByName(DeleteRoomRequest deleteRequest);
}
