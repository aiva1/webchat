package lv.javaguru.java2.businesslogic.api;

public class DeleteRoomResponse {

    private boolean isRemoved;

    public DeleteRoomResponse(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public boolean isRemoved() {
        return isRemoved;
    }
}
