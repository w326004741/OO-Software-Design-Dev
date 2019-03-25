import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

import models.Account;
import models.Customer;


/**
 * in default package (under app folder)
 */
@OnApplicationStart   // 如果有这个Annotation，当你在这个类修改数据时，你必须restart server, 如果没有这个Annotation, 就不用重启Server，直接刷新就可以
// for @OnApplicationStart  start run before your any class. 当该项目启动后，第一个run的class 并 run 内部的 doJob()方法
public class Bootstrap extends Job {

    //This doJob() function is used to clean the database and create some sample objects
    public void doJob() {
        // Clear all data of database
        Fixtures.deleteDatabase();

        // Check if there are no existing accounts
        if (Account.count() == 0) {
            // Create and save two new accounts   // for account table
            new Account(221, false).save();
            new Account(222, false).save();
            new Account(223, true).save();
            new Account(224, true).save();
        }

        // Check if there are no existing customers
        if (Customer.count() == 0) {
            // for customer table
            // Find an existing account
            Account acc = Account.find("byAccountNumber", 222).first();
            Account acc1 = Account.find("byAccountNumber", 223).first();
            Account acc2 = Account.find("byAccountNumber", 221).first();

            // Create and save a new customer
            new Customer(acc2, 21, "Weichen").save();
            new Customer(acc, 22, "Bob").save();
            new Customer(acc1, 23, "Wang").save();
        }
    }

}