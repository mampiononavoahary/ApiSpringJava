package Repository;

import Database.DatabaseConnection;
import Model.Subscribers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscribersCrudOperations implements CrudOperaions<Subscribers> {
    DatabaseConnection dbc = new DatabaseConnection();
    Connection connection = dbc.CreateConnection();

    public SubscribersCrudOperations() throws SQLException, ClassNotFoundException {
    }

    @Override
    public List<Subscribers> findAll() {
        List<Subscribers> array = new ArrayList<>();
        String sql = "SELECT * FROM Subscribers;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                array.add(new Subscribers(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("sex"),
                        resultSet.getString("reference")
                ));
            }
            for (Subscribers subscribers: array){
                System.out.println(subscribers);
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
        return array;
    }

    @Override
    public List<Subscribers> saveAll(List<Subscribers> toSave) {
        String query = "INSER INTO Subscribers(id,name,sex,reference) VALUES(?,?,?,?);";
        List<Subscribers> SavedSubscribers = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            for (Subscribers subscribers: SavedSubscribers){

                preparedStatement.setString(1, subscribers.getId());
                preparedStatement.setString(2, subscribers.getName());
                preparedStatement.setString(3, subscribers.getSex());
                preparedStatement.setString(4, subscribers.getReference());

               int rows = preparedStatement.executeUpdate();
               while (rows>0){
                   SavedSubscribers.add(subscribers);
               }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return SavedSubscribers;
    }

    @Override
    public Subscribers save(Subscribers toSave) {
        String query = "INSERT INTO Subscribers(id,name,sex,reference) VALUES(?,?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1,toSave.getId());
            preparedStatement.setString(2,toSave.getName());
            preparedStatement.setString(3,toSave.getSex());
            preparedStatement.setString(4,toSave.getReference());

            System.out.println("Inseted Successfuly");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toSave;
    }

    @Override
    public Subscribers delete(Subscribers toDelete) {
        String sql = "DELETE FROM Subscribers WHERE id=?;";

        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,toDelete.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
