package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.junit.validator.PublicClassValidator;

import play.db.jpa.Model;

@Entity
public class Customer extends Model {

    public Integer customerNumber;
    public String customerName;

    // Here Customer maintains the one-to-on relationship with Account
    @OneToOne
    public Account account;

    public Customer(Account acc, int custNum, String name) {
        this.customerNumber = custNum;
        this.customerName = name;
        this.account = acc;
    }

    public Account getAccount() {
        return this.account;
    }

    public Integer getCustomerNumber() {
        return this.customerNumber;
    }

    public String getCustomerName() {
        return this.customerName;
    }
}
