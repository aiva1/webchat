package lv.javaguru.java2.businesslogic.api;

public class CreateCharacterResponse {

    private boolean creationSuccess;

    public CreateCharacterResponse(boolean creationSuccess) {
        this.creationSuccess = creationSuccess;
    }

    public boolean isCreationSuccess() {
        return creationSuccess;
    }
}
