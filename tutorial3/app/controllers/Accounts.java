package controllers;

import models.Account;
import play.*;
import play.mvc.*;

@With(Secure.class)
@CRUD.For(Account.class)
public class Accounts extends CRUD {
}