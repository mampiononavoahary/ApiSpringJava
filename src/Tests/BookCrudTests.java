package Tests;

import Model.Book;
import Repository.BookCrudOperations;

import javax.print.attribute.standard.MediaSize;
import java.sql.SQLException;

public class BookCrudTests {
    public static void BookCrudTests() throws SQLException, ClassNotFoundException {
        BookCrudOperations bookCrudOperations = new BookCrudOperations();

       bookCrudOperations.findAll();
//        Book book = new Book(2,"BookC",300,"OTHER", "2023-12-12","1",true);
//       bookCrudOperations.save(book);

    }
}
