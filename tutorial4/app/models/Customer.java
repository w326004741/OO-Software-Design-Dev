package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.junit.validator.PublicClassValidator;

import play.db.jpa.Model;

@Entity
public class Customer extends Model {
	
	public Integer customerNumber;
	public String customerName;
	
	// Here Customer maintains the one-to-on relationship with Account
	@OneToMany
	public Set<Account> accounts;  

	@OneToMany 
	public Set<Customer> related;
	
	public Customer(Integer customerNumber, String customerName) {
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.accounts = new HashSet<>();
		this.related = new HashSet<>();
	}
}
