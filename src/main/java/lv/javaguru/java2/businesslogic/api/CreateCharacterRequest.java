package lv.javaguru.java2.businesslogic.api;

public class CreateCharacterRequest {

    private String name;
    private char sex;
    private String bio;

    public CreateCharacterRequest(String name, char sex, String bio) {
        this.name = name;
        this.sex = sex;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public String getBio() {
        return bio;
    }

}
