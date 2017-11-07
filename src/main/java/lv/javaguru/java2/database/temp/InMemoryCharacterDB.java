package lv.javaguru.java2.database.temp;

import lv.javaguru.java2.domain.Character;
import lv.javaguru.java2.database.CharacterDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryCharacterDB implements CharacterDAO {

    private List<Character> characters;


    public InMemoryCharacterDB() {
        characters = new ArrayList<>();
    }

    @Override
    public Character save(Character character) {
        characters.add(character);
        return character;
    }

    @Override
    public Optional<Character> getById(Long id) {
        return null;
    }

    @Override
    public Optional<Character> getByName(String name) {

        Character toReturn = null;
        Optional<Character> foundCharacter = characters.stream()
                .filter(ch -> ch.getName().equals(name))
                .findFirst();
        if (foundCharacter.isPresent()) {
            toReturn = foundCharacter.get();
        }
        return Optional.ofNullable(toReturn);
    }

    @Override
    public void delete(Character character) {
        Optional<Character> foundCharacter = characters.stream()
                .filter(ch -> ch.getName().equals(character.getName()))
                .findFirst();

        if (foundCharacter.isPresent()) {
            characters.remove(foundCharacter.get());
        }
    }

    @Override
    public List<Character> getAll() {
        return characters;
    }
}
