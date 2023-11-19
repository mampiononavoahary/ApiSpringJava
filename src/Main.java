import Tests.AuthorCrudTests;
import Tests.BookCrudTests;
import Tests.SubscribersCrudTests;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AuthorCrudTests.AuthorCrudTests();
        BookCrudTests.BookCrudTests();
        SubscribersCrudTests.SubscribersCrudTests();
    }
}
