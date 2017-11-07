package lv.javaguru.java2.domain;

public class Character {

    private Long id;
    private String name;
    private char sex;
    private String bio;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Character{" +
                "id= " + id +
                "name= " + name +
                ", sex= " + sex +
                ", bio= " + bio +
                "}";
    }
}