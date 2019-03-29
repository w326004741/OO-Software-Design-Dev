package controllers;
 
import models.Customer;
import play.*;
import play.mvc.*;

@With(Secure.class)
@CRUD.For(Customer.class)
public class Customers extends CRUD {    
}