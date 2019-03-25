package models;

import javax.persistence.Entity;

import play.db.jpa.Model;


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
    private boolean isCurrentAccount;

    public Account(int accNum, boolean isCurrAcc) {
        this.accountNumber = accNum;
        this.isCurrentAccount = isCurrAcc;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public boolean isCurrentAccount() {
        return this.isCurrentAccount;
    }
}
