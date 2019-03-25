package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.junit.validator.PublicClassValidator;

import play.db.jpa.Model;

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

    // Here Customer maintains the one-to-on relationship with Account
    @OneToOne // One Customer has One account in this case (Relationship could be One to One(0...1) )
    private Account account;

    // Default Constructor
    public Customer(Account acc, int custNum, String name) {
        this.customerNumber = custNum;
        this.customerName = name;
        this.account = acc;
    }

    public Account getAccount() {
        return this.account;
    }

    public int getCustomerNumber() {
        return this.customerNumber;
    }

    public String getCustomerName() {
        return this.customerName;
    }
}
