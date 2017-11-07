package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.domain.Character;
import lv.javaguru.java2.businesslogic.api.DeleteCharacterRequest;
import lv.javaguru.java2.businesslogic.DeleteCharacterService;
import lv.javaguru.java2.businesslogic.api.DeleteCharacterResponse;
import lv.javaguru.java2.database.CharacterDAO;

import java.util.Optional;

public class DeleteCharacterServiceImpl implements DeleteCharacterService {

    private CharacterDAO characterDAO;

    public DeleteCharacterServiceImpl(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    @Override
    public DeleteCharacterResponse deleteByName(DeleteCharacterRequest deleteRequest) {
        Optional<Character> charactersOpt = characterDAO.getByName(deleteRequest.getName());

        if (charactersOpt.isPresent()) {
            Character character = charactersOpt.get();
            characterDAO.delete(character);
            return new DeleteCharacterResponse(true);
        }

        return new DeleteCharacterResponse(false);
    }
}
