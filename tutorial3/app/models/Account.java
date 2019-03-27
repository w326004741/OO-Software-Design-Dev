package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Account extends Model {

    public Integer accountNumber;
    public Boolean isCurrentAccount;

    public Account(int accNum, boolean isCurrAcc) {
        this.accountNumber = accNum;
        this.isCurrentAccount = isCurrAcc;
    }

    public Integer getAccountNumber() {
        return this.accountNumber;
    }

    public Boolean isCurrentAccount() {
        return this.isCurrentAccount;
    }
}
