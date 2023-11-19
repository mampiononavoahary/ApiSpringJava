package Tests;

import Model.Book;
import Model.Subscribers;
import Repository.SubscribersCrudOperations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscribersCrudTests {
    public static void SubscribersCrudTests() throws SQLException, ClassNotFoundException {
        SubscribersCrudOperations subscribersCrudOperations = new SubscribersCrudOperations();

        Subscribers subscribers = new Subscribers("1","ERIC","H","SD1235");
        subscribersCrudOperations.save(subscribers);

//        List<Subscribers> SaveASubscribers = new ArrayList<>();
//        SaveASubscribers.add(new Subscribers("2","JANE","H","SD1235"));
//        SaveASubscribers.add(new Subscribers("3","JACK","F","SD121325"));
//        List<Subscribers> savedSubscribers = subscribersCrudOperations.saveAll(SaveASubscribers);
//
//        System.out.println("Saved Subscribers:");
//        for (Subscribers subscribers1 : savedSubscribers) {
//            System.out.println(subscribers1);
//        }
        subscribersCrudOperations.findAll();

        Subscribers DeleteSubscribers = subscribers;
        Subscribers removeSubscribers = subscribersCrudOperations.delete(DeleteSubscribers);
        System.out.println("Subscribers deleted"+removeSubscribers);
    }

}
