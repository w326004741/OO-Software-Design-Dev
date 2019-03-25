package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;

/**
 * Controller class
 */
public class Application extends Controller {

    // index() function 内的所有代码块的输出都会在 index.html（index 方法名和 index.html 文件名一致）这个页面输出
    public static void index() {
        // add two list in here
        // Both classes extend the play.db.jpa.Model class that provides useful JPA helps such as automatic IDs and find() functions.
        List<Account> accounts = Account.findAll();
        List<Customer> customers = Customer.findAll();

        render(accounts, customers);
    }

    // create a new method check(), meaning now have 2 controller in this class. 对应check.html file,每个方法/Controller对应一个html文件
    public static void check() {
        List<Account> accounts = Account.findAll();
        List<Customer> customers = Customer.findAll();

        render(accounts, customers);  //render(): 调用这个方法内的所有内容到check.html输出。放在最后调用,记得调用参数
    }

    /**
     * Source Code: https://pastebin.com/GwnaXMaA
     */
    public static void postAccountAndCustomer(@Required Long accountId, @Required Long customerId) {
        // findById(): find one object from the list of customer
        Customer customer = Customer.findById(customerId);
        Account account = Account.findById(accountId);

        if (customer.getAccount().equals(account)) {
            // flash:
            flash.success("Yes %s is owner of account number %s", customer.getCustomerName(), customer.getAccount());
        } else {
            flash.error("No %s is not owner of account number %s", customer.getCustomerName(), account.getAccountNumber());
        }
        check();

    }

}