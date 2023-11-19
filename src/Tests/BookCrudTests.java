package Tests;

import Model.Author;
import Model.Book;
import Repository.BookCrudOperations;

import javax.print.attribute.standard.MediaSize;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCrudTests {
    public static void BookCrudTests() throws SQLException, ClassNotFoundException {
        BookCrudOperations bookCrudOperations = new BookCrudOperations();



        Book book = new Book(1,"BookC",300, Model.Book.Topic.COMMEDY, "2023-12-12","1",true);
       bookCrudOperations.save(book);


        List<Book> SaveAllBooks = new ArrayList<>();
        SaveAllBooks.add(new Book(2,"BookC",300,Model.Book.Topic.ROMMAN, "2023-12-12","1",true));
        SaveAllBooks.add(new Book(3,"BookC",300,Model.Book.Topic.OTHER, "2023-12-12","1",true));
        List<Book> savedBooks = bookCrudOperations.saveAll(SaveAllBooks);
        System.out.println("Saved Books:");
        for (Book books : savedBooks) {
            System.out.println(books);
        }

        bookCrudOperations.findAll();
        Book DeleteBook = book;
        Book removeBook = bookCrudOperations.delete(DeleteBook);

        System.out.println("Author deleted"+ removeBook);

    }
}
