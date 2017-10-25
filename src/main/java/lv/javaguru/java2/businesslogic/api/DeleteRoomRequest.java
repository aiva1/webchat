package lv.javaguru.java2.businesslogic.api;

public class DeleteRoomRequest {

    private String name;

    public DeleteRoomRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
