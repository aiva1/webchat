package lv.javaguru.java2.businesslogic.api;

public class CreateRoomResponse {

    private boolean isCreationSuccess;

    public CreateRoomResponse(boolean isCreationSuccess) {
        this.isCreationSuccess = isCreationSuccess;
    }

    public boolean isCreationSuccess() {
        return isCreationSuccess;
    }
}

