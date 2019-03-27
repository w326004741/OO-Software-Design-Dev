package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import models.*;


public class Application extends Controller {

    /**
     * Action method for index.html view template.
     */
    public static void index() {
        List<Account> accounts = Account.findAll();
        List<Customer> customers = Customer.findAll();

        render(accounts, customers);
    }

    /**
     * Action method for check.html view template.
     */
    public static void check() {
        List<Account> accounts = Account.findAll();
        List<Customer> customers = Customer.findAll();

        render(accounts, customers);
    }


    public static void postAccountAndCustomer(@Required Long accountId, @Required Long customerId) {
        Customer customer = Customer.findById(customerId);
        Account account = Account.findById(accountId);

        if (validation.hasErrors()) {
            render("Application/check.html");
        }

        System.out.println(customerId);
        System.out.println(accountId);

        if (customer.getAccount().equals(account)) {
            flash.success("Yes %s is owner of account number %s", customer.getCustomerName(), account.getAccountNumber());
        } else {
            flash.error("No %s is not owner of account number %s", customer.getCustomerName(), account.getAccountNumber());
        }
        check();
    }

}