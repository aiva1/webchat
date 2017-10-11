package lv.javaguru.java2;

public class Character {

    private String name;
    private boolean isMale;
    private String bio;


    public void setName(String name) {
        this.name = name;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public void setBio(String bio) {
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

    @Override
    public String toString() {
        return "Character{"+
                "name= " + name + ", " + (isMale ? "Male" : "Female") + ", bio= " + bio +
                "}";
    }
}