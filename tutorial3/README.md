# Code for Tutorial 2 of Play Framework 

This project contains extended code from the Play Framework tutorial in lab on __Wednesday, March 25, 2019__. 

### Overview of code changes
The project contains following changes compared to the `tutorial2.zip` code provided earlier.

1. A modified version of the `Application.java` file in `tutorial3/app/controllers` package.
    * The `Application` class has two new action methods.
    * The `check()` method is called when a user visits the `http://localhost:9000/check` URL in browser. The structure of this method is very similar to the `index()` method.
    * The `postAccountAndCustomer()` method is call is called when user submits the form on the webpage of `http://localhost:9000/check`. 
    
2. A new view template in `check.html` file in `/tutorial2/app/views/Application` folder.
    * This view is used user to check whether a selected account is owned by a selected customer
    * This template generates HTML with a form and two dropdowns (one for choosing a customer and one for choosing an account).
    * It submits the selected customer and account as `customerId` and `accountId` variables, respectively, to the `postAccountAndCustomer()` action method.
    * It also displays the `flash.error` and `flash.success` messages sent by `postAccountAndCustomer()` action method.

3. A modified version of the `dependencies.yml` file in `tutorial3/conf` folder.
    * This file defines the Play Framework module needed for this application.
    * This version adds `- play -> crud` line to include Administrative CRUD module to the application
    * You must run the command `play dependencies` to enable the application to load or remove modules. 

4. Two new controllers the `tutorial3/app/controllers` package.
    * Both `Customers.java` and `Accounts.java` contain respective classes for to use the generic CRUD views and actions methods.
    * Both class extend from `CRUD` class that is part of the newly added module.
    * This allows `http://localhost:9000/admin/` URL to exposed create, retrieve, update, and delete functionaly for objects.

### Installation Notes:
1. Extract the zip file to your Eclipse workspace (or any other folder where you keep your projects). 
2. From the command line interface (CLI), i.e. `cmd` in Windows or `terminal` in Mac, navigate to the `tutorial2` folder and use `play run` or `play test` commands to test the application. 
3. Make sure that you have a working installation of Play Framework by checking that following environment variables are correctly set.
    * Downlaod and install __Java 8 SDK__ from https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
    * Download and extract __Play Framework 1.5.2__ from https://www.dropbox.com/s/reiub03a1m7mlne/play1-1.5.2.zip?dl=0 
    * The `PATH` variable points to the `bin` folder of the Java SDK. You can test this by running `javac -version` command in CLI
    * The `PATH` variable also points to the Play Framework folder. You can test this by running `play help` command in CLI.
    * The `JAVA_HOME` variable points to the Java SDK folder. 