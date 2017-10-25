package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.api.DisplayCharactersResponse;
import lv.javaguru.java2.businesslogic.DisplayCharactersService;
import lv.javaguru.java2.database.CharacterDAO;

public class DisplayCharactersServiceImpl implements DisplayCharactersService {

    private CharacterDAO characterDAO;

    public DisplayCharactersServiceImpl(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    @Override
    public DisplayCharactersResponse getCharacters() {
        return new DisplayCharactersResponse(characterDAO.getAll());
    }
}
