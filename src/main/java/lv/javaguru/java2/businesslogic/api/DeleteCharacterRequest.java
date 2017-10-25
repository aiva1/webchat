package lv.javaguru.java2.businesslogic.api;

public class DeleteCharacterRequest {

    private String name;

    public DeleteCharacterRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
