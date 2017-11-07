package lv.javaguru.java2.domain;

public class CharacterBuilder {

    private Long id;
    private String name;
    private char sex;
    private String bio;

    private CharacterBuilder() {}

    public static CharacterBuilder createCharacter() {
        return new CharacterBuilder();
    }

    public static Character createCharacter(String name, char sex, String bio) {
        return createCharacter()
                .withName(name)
                .withSex(sex)
                .withBio(bio)
                .build();
    }

    public Character build() {
        Character character = new Character();
        character.setId(id);
        character.setName(name);
        character.setSex(sex);
        character.setBio(bio);

        return character;
    }

    public CharacterBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CharacterBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CharacterBuilder withSex(char sex) {
        this.sex = sex;
        return this;
    }

    public CharacterBuilder withBio(String bio) {
        this.bio = bio;
        return this;
    }
}
