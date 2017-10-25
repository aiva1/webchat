package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.api.DeleteCharacterRequest;
import lv.javaguru.java2.businesslogic.api.DeleteCharacterResponse;

public interface DeleteCharacterService {

    DeleteCharacterResponse deleteByName(DeleteCharacterRequest deleteRequest);
}
