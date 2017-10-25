package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.api.CreateCharacterRequest;
import lv.javaguru.java2.businesslogic.api.CreateCharacterResponse;

public interface CreateCharacterService {
    CreateCharacterResponse createCharacter(CreateCharacterRequest createRequest);
}
