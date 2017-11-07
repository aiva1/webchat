package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.domain.Character;
import lv.javaguru.java2.businesslogic.api.CreateCharacterRequest;
import lv.javaguru.java2.businesslogic.api.CreateCharacterResponse;
import lv.javaguru.java2.businesslogic.CreateCharacterService;
import lv.javaguru.java2.database.CharacterDAO;

public class CreateCharacterServiceImpl implements CreateCharacterService {

    private CharacterDAO characterDAO;

    public CreateCharacterServiceImpl(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    @Override
    public CreateCharacterResponse createCharacter(CreateCharacterRequest createRequest) {
        Character character = new Character();
        character.setName(createRequest.getName());
        character.setSex(createRequest.getSex());
        character.setBio(createRequest.getBio());
        characterDAO.save(character);

        return new CreateCharacterResponse(true);
    }
}
