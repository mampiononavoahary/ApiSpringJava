package Repository;

import Database.DatabaseConnection;
import Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookCrudOperations implements CrudOperaions<Book>{

     DatabaseConnection dbc = new DatabaseConnection();
     Connection connection = dbc.CreateConnection();

    public BookCrudOperations() throws SQLException, ClassNotFoundException {
    }

    @Override
    public List<Book> findAll() {
        List<Book> array = new ArrayList<>();
        String sql = "SELECT * FROM book;";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                array.add(new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("bookName"),
                        resultSet.getInt("pagesNumbers"),
                        resultSet.getString("topicEnum"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("authorId"),
                        resultSet.getBoolean("status")
                ));
            }

            for (Book book : array){
                System.out.println(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return array;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        String sql = "INSERT INTO Book(id,bookName,pagesNumbers,topicEnum,releaseDate,authorId,status)VALUES(?,?,?,?,?,?,?);";
        List<Book> SavedBook = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            for (Book book :SavedBook){
                statement.setInt(1,book.getId());
                statement.setString(2, book.getBookName());
                statement.setInt(3,book.getPageNumbers());
                statement.setString(4, book.getTopicEnum());
                statement.setDate(5,book.getReleaseDate());
                statement.setString(6, book.getAuthorId());
                statement.setBoolean(7,book.getStatus());

                int rows = statement.executeUpdate();
                if (rows>0){
                   SavedBook.add(book);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return SavedBook;
    }

    @Override
    public Book save(Book toSave) {
        String requette = "INSERT INTO Book(id,bookName,pagesNumbers,topicEnum,releaseDate,authorId,status) VALUES (?,?,?,?,?,?,?);";

        try (PreparedStatement statement = connection.prepareStatement(requette)){
            statement.setInt(1,toSave.getId());
            statement.setString(2,toSave.getBookName());
            statement.setInt(3,toSave.getPageNumbers());
            statement.setString(4, toSave.getTopicEnum());
            statement.setDate(5,toSave.getReleaseDate());
            statement.setString(6,toSave.getAuthorId());
            statement.setBoolean(7,toSave.getStatus());

            int rows = statement.executeUpdate();
            if (rows>0){
                System.out.println("Book inseted");
            }
        }catch (Exception e){
            throw new RuntimeException("Error in inserted :"+e+"");
        }
        return toSave;
    }

    @Override
    public Book delete(Book toDelete) {
        String sql = "DELETE FROM Book WHERE id=?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,toDelete.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
