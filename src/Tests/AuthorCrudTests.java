package Tests;

import Model.Author;
import Repository.AuthorCrudOperations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudTests {
    public static void AuthorCrudTests() throws SQLException, ClassNotFoundException {
        AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations();



        Author author = new Author("3","NAIVO","H");
        authorCrudOperations.save(author);

        List<Author> SaveAllAuthors = new ArrayList<>();
        SaveAllAuthors.add(new Author("1" , "SAM" , "H")) ;
        SaveAllAuthors.add(new Author("2" ,"LUX" , "F")) ;
        List<Author> savedAuthors = authorCrudOperations.saveAll(SaveAllAuthors);
        System.out.println("Saved Authors:");
        for (Author authors : savedAuthors) {
            System.out.println(authors);
        }

        authorCrudOperations.findAll();

        Author DeleteAuthor = author;
        Author removeAuthor = authorCrudOperations.delete(DeleteAuthor);

        System.out.println("Author deleted"+ removeAuthor);
    }
}
