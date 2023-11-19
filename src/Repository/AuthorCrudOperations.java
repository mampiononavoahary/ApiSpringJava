package Repository;

import Database.DatabaseConnection;
import Model.Author;
import Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperations implements CrudOperaions<Author>{
    DatabaseConnection dbc = new DatabaseConnection();
    Connection connection = dbc.CreateConnection();

    public AuthorCrudOperations() throws SQLException, ClassNotFoundException {
    }

    @Override
    public List<Author> findAll() {
        List<Author> array = new ArrayList<>();
        String sql = "SELECT * FROM Author;";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                array.add(new Author(
                        resultSet.getString("authorId"),
                        resultSet.getString("authorName"),
                        resultSet.getString("sex")
                ));
            }
            for (Author authors: array){
                System.out.println(authors);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return array;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        String sql = "INSERT INTO Author(authorId,authorName,sex)VALUES(?,?,?);";
        List<Author> array = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            for (Author author : toSave){
                statement.setString(1, author.getAuthorId());
                statement.setString(2, author.getAuthorName());
                statement.setString(3, author.getSex());

                int rows = statement.executeUpdate();
                if (rows>0){
                    System.out.println("Author inserted");
                    array.add(author);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return array;
    }

    @Override
    public Author save(Author toSave) {
        try {
            String query = "INSERT INTO Author(authorId,authorName,sex)VALUES(?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setString(1,toSave.getAuthorId());
                preparedStatement.setString(2,toSave.getAuthorName());
                preparedStatement.setString(3,toSave.getSex());

                preparedStatement.executeUpdate();
                System.out.println("Author inserted");
               }
            }catch (SQLException e) {
               throw new RuntimeException(e);
            }
        return toSave;
    }

    @Override
    public Author delete(Author toDelete) {
        String sql = "DELETE FROM Author WHERE authorId=?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,toDelete.getAuthorId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
