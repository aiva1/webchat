package lv.javaguru.java2.businesslogic.api;

import lv.javaguru.java2.domain.Character;

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
