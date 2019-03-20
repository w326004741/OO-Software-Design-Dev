package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Weichen Wang
 * @date 2019/3/20 - 11:16 AM
 * @description: ${description}
 * <p>
 * is a immutable because no have setter method, so cannot change 不可变的是因为没有setter method
 */

@Entity
public class Customer extends Model {

    private int customerNumber;
    private String customerName;

    @OneToOne // One Customer has One account in this case (Relationship could be One to One(0...1) )
    private Account account;

    // Default Constructor
    public Customer(Account account, int customerNumber, String name) {
        this.customerNumber = customerNumber;
        this.account = account;
        this.customerName = name;
    }

    // getter Account method
    public Account getAccount() {
        return account;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
}
