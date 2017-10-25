package lv.javaguru.java2.businesslogic.api;

public class CreateCharacterRequest {

    private String name;
    private boolean isMale;
    private String bio;

    public CreateCharacterRequest(String name, boolean isMale, String bio) {
        this.name = name;
        this.isMale = isMale;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public String getBio() {
        return bio;
    }

}
