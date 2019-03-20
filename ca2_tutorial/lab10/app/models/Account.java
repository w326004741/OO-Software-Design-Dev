package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * @author Weichen Wang
 * @date 2019/3/20 - 10:25 AM
 * @description: 1. @Entity
 * 2. extends Model
 * 3. test/BasicTest class
 * 4. New Constructor & Add getter method
 * 5. New Customer class
 */

@Entity
public class Account extends Model {
    private int accountNumber;


    // New Contrustor
    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Add getter method
    public int getAccountNumber() {
        return this.accountNumber;
    }
}
