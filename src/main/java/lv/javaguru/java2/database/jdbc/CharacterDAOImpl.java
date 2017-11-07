package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.CharacterDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Character;
import lv.javaguru.java2.domain.CharacterBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CharacterDAOImpl extends DAOImpl implements CharacterDAO {

    @Override
    public Character save(Character character) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sqlStatement = "INSERT INTO characters(id, name, sex, bio) values (default, ?, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sqlStatement, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, character.getName());
            preparedStatement.setString(2, String.valueOf(character.getSex()));
            preparedStatement.setString(3, character.getBio());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                character.setId(rs.getLong(1));
            }
        }
        catch (Throwable e) {
            System.out.println("Exception while executing CharacterDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }

        return character;
    }

    @Override
    public Optional<Character> getById(Long id) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sqlStatement = "SELECT * FROM characters WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            Character character = null;

            if (resultSet.next()) {
                character = CharacterBuilder.createCharacter()
                            .withId(resultSet.getLong("id"))
                            .withName(resultSet.getString("name"))
                            .withSex(resultSet.getString("sex").charAt(0))
                            .withBio(resultSet.getString("bio"))
                            .build();
            }
            return Optional.ofNullable(character);
        }
        catch (Throwable e) {
            System.out.println("Exception while executing CharacterDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }

    }

    @Override
    public Optional<Character> getByName(String name) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sqlStatement = "SELECT * FROM characters WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            Character character = null;

            if (resultSet.next()) {
                character = CharacterBuilder.createCharacter()
                        .withId(resultSet.getLong("id"))
                        .withName(resultSet.getString("name"))
                        .withSex(resultSet.getString("sex").charAt(0))
                        .withBio(resultSet.getString("bio"))
                        .build();
            }
            return Optional.ofNullable(character);
        }
        catch (Throwable e) {
            System.out.println("Exception while executing CharacterDAOImpl.getByName()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Character character) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "DELETE FROM characters WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, character.getId());
            preparedStatement.executeUpdate();
        }
        catch (Throwable e) {
            System.out.println("Exception while executing CharacterDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }

    }

    @Override
    public List<Character> getAll() {
        List<Character> characters = new ArrayList<>();
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "SELECT * FROM characters";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Character character = CharacterBuilder.createCharacter()
                        .withId(resultSet.getLong("id"))
                        .withName(resultSet.getString("name"))
                        .withSex(resultSet.getString("sex").charAt(0))
                        .withBio(resultSet.getString("bio"))
                        .build();
                characters.add(character);
            };
        }
        catch (Throwable e) {
            System.out.println("Exception while executing CharacterDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }

        return characters;
    }
}
