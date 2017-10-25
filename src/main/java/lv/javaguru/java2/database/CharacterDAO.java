package lv.javaguru.java2.database;

import lv.javaguru.java2.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterDAO {

    Character save(Character character);

    Optional<Character> getByName(String name);

    void delete(Character character);

    List<Character> getAll();
}
