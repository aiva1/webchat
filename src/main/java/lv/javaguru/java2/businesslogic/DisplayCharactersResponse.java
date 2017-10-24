package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.Character;

import java.util.List;

public class DisplayCharactersResponse {

    private List<Character> characters;

    public DisplayCharactersResponse(List<Character> characters) {

        this.characters = characters;
    }

    public List<Character> getCharacters() {

        return characters;
    }
}