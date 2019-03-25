import org.junit.*;

import java.util.*;

import play.test.*;
import models.*;

import models.Account;

public class BasicTest extends UnitTest {

    // This function will first in this test
    @Before
    public void setup() {
        // Clear the database
        Fixtures.deleteDatabase();
    }

    // Test all of your class in the Model
    @Test
    public void createAndRetrieveAccount() {
        // Create an account
        Account a = new Account(12345, false);

        // Save to the database. is not persistence for now ,only store in your memeory(close project->Data gone)
        a.save(); // save(): store(e.g insert) the entity。 return true if successful


        // Find the account with "accountNumber=12345"
        // by captured accountNumber, remove 'by', still work
        // the .find() functin from Model class(Account extends Model)
        Account acc = Account.find("byAccountNumber", 12345).first(); // like JPQL(Java Persistence Query Language)

        // Check that the account exists // Check that an object isn't null 检查对象不为空
        assertNotNull(acc);

        // Check if the account number of found account matches with 12345
        // assertEquals(): 判断两个对象是否相等，并返回boolean, int等类型，前为期望值，后为输入值
        assertEquals(12345, acc.getAccountNumber());
    }

    @Test
    public void createAndRetrieveCustomer() {
        // Create and save an account
        Account a = new Account(678, false).save();

        // Create and save a customer
        new Customer(a, 1, "NoName").save();

        // Find the customer with "customerNumber=1"
        Customer cust = Customer.find("byCustomerNumber", 1).first();

        // Check that the customer exists
        assertNotNull(cust);

        // Check if the account of found customer is same as the account created above
        assertEquals(cust.getAccount().getAccountNumber(), 678);

        // Check if the customer number of found customer matches with 1
        assertEquals(cust.getCustomerNumber(), 1);

        // Check if the customer name of found customer matches with "NoName"
        assertEquals(cust.getCustomerName(), "NoName");
    }
}
