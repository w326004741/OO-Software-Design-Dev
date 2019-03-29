package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Account extends Model {
	
	public Integer accountNumber;
	public Boolean currentAccount;

	@ManyToOne
	public Customer customer;
	
	public Account(Integer accountNumber, boolean currentAccount) {
		this.accountNumber = accountNumber;
		this.currentAccount = currentAccount;
	}
}
