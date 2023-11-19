package Tests;

import Model.Subscribers;
import Repository.SubscribersCrudOperations;

import java.sql.SQLException;

public class SubscribersCrudTests {
    public static void SubscribersCrudTests() throws SQLException, ClassNotFoundException {
        SubscribersCrudOperations subscribersCrudOperations = new SubscribersCrudOperations();

        subscribersCrudOperations.findAll();
        Subscribers subscribers = new Subscribers("3","ERIC","H","SD1235");
        subscribersCrudOperations.save(subscribers);
    }
}
