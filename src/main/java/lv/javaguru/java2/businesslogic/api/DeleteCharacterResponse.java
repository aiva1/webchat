package lv.javaguru.java2.businesslogic.api;

public class DeleteCharacterResponse {

    private boolean isDeleted;

    public DeleteCharacterResponse(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}
