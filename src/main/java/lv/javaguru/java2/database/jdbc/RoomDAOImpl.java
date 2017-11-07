package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.RoomDAO;
import lv.javaguru.java2.domain.Room;
import lv.javaguru.java2.domain.RoomBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomDAOImpl extends DAOImpl implements RoomDAO {

    @Override
    public Room save(Room room) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sqlStatement = "INSERT INTO rooms(id, name, capacity, description) values (default, ?, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sqlStatement, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, room.getName());
            preparedStatement.setInt(2, room.getCapacity());
            preparedStatement.setString(3, room.getDescription());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                room.setId(rs.getLong(1));
            }
        }
        catch (Throwable e) {
            System.out.println("Exception while executing RoomDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
        return room;
    }


    @Override
    public Optional<Room> getById(Long id) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sqlStatement = "SELECT * FROM rooms WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            Room room = null;

            if (resultSet.next()) {
                room = RoomBuilder.createRoom()
                        .withId(resultSet.getLong("id"))
                        .withName(resultSet.getString("name"))
                        .withCapacity(resultSet.getInt("capacity"))
                        .withDescription(resultSet.getString("description"))
                        .build();
            }
            return Optional.ofNullable(room);
        }
        catch (Throwable e) {
            System.out.println("Exception while executing RoomDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<Room> getByName(String name) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sqlStatement = "SELECT * FROM rooms WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            Room room = null;

            if (resultSet.next()) {
                room = RoomBuilder.createRoom()
                        .withId(resultSet.getLong("id"))
                        .withName(resultSet.getString("name"))
                        .withCapacity(resultSet.getInt("capacity"))
                        .withDescription(resultSet.getString("description"))
                        .build();
            }
            return Optional.ofNullable(room);
        }
        catch (Throwable e) {
            System.out.println("Exception while executing RoomDAOImpl.getByName()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Room room) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "DELETE FROM rooms WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, room.getId());
            preparedStatement.executeUpdate();
        }
        catch (Throwable e) {
            System.out.println("Exception while executing RoomDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Room> getAll() {
        List<Room> rooms = new ArrayList<>();
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "SELECT * FROM rooms";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Room room = RoomBuilder.createRoom()
                        .withId(resultSet.getLong("id"))
                        .withName(resultSet.getString("name"))
                        .withCapacity(resultSet.getInt("capacity"))
                        .withDescription(resultSet.getString("description"))
                        .build();
                rooms.add(room);
            }
        }
        catch (Throwable e) {
            System.out.println("Exception while executing RoomDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }

        return rooms;
    }
}
