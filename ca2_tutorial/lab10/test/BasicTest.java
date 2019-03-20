import org.bouncycastle.asn1.cmc.CMCUnsignedData;
import org.junit.*;

import java.util.*;

import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Before
    // @Before: this function will first in this test
    // 设定setup()在该Test class第一个run的method
    public void setup() {
        // clear the database  (each time of start the test class)
        Fixtures.deleteDatabase();
    }

    // create this function with @Test
    // play test in terminal(check in the project folder)
    // change to (long)1 -> because the type of id in Model is 'long' (default type of id)
    @Test
    public void createAndRetrieveAccount() {
        // Create an account
        Account acc1 = new Account(12345);
        // Save to the database, is not persistence for now ,only store in your memeory(close project->Data gone)
        acc1.save(); // save(): store(e.g insert) the entity。 return true if successful

        // by captured accountNumber, remove 'by', still work
        // the .find() functin from Model class(Account extends Model)
        Account acc2 = Account.find("AccountNumber", 12345).first(); // like JPQL(Java Persistence Query Language)

        // this will generate an error
        assertNotNull(acc2); // Check that an object isn't null 检查对象不为空
        assertEquals(12345, acc2.getAccountNumber()); // asserEquals(): 判断两个对象是否相等，并返回boolean, int等类型，前为期望值，后为输入值

    }

    @Test
    public void createAdnRetrieveCustomer() {
        Account acc = new Account(678).save(); // assigned value & save to the database
        Customer c = new Customer(acc, 1, "weichen").save(); // don't wanna reference of Object,just set argument value & save to the db
        // find a list from Customer Object & first() to get the first one of list
        Customer cust = Customer.find("byCustomerNumber", c.getCustomerNumber()).first();
        Customer cust1 = Customer.find("byCustomerName", c.getCustomerName()).first();

        assertNotNull(cust);
        assertEquals(cust.getAccount().getAccountNumber(), 678);

        assertEquals(c.getCustomerNumber(), cust.getCustomerNumber());
        assertEquals(c.getCustomerName(), cust1.getCustomerName());
    }

}
//    @Test
//    public void aVeryImportantThingToTest() {
//        // 判断两个object是否相等, expected 期望值，actual 实际输入值
//        assertEquals(2, 1 + 1);
//    }
