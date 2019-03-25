# Code for Tutorial 2 of Play Framework 

This project contains extended code from the Play Framework tutorial in lab on __Wednesday, March 20, 2019__. 

### Overview of code changes
The project contains following changes compared to the default files generate by Play Framework when creating a new appliction using `play new tutorial2`.

1. Two new files in the `tutorial2/app/models` folder
    * This folder contains the code for the __model__ layer of MVC pattern.
    * We created the `Account.java` file that contains code for the `Account` class.
    * We also created the `Customer.java` file that contains code for the `Customer` class.
    * Both classes were annotated with the `@Entity` by importing `javax.persistence.Entity`. This marks both class as JPA managed entities that can be persisted to a database.
    * Both classes extend the `play.db.jpa.Model` class that provides useful JPA helps such as automatic IDs and `find()` functions.

2. Modified version of the `BasicTest.java` file in `tutorial2/test/` folder. It contains following three functions:
    * The `setup()` function to clear the database. This function will run before any test due to the `@Before` annotation.
    * The `createAndRetrieveAccount()` function that defines a test, using the `@Test` annotation, in Play Framework for unit testing the `Account` class.
    * The `createAndRetrieveCustomer()` function that defines a test in Play Framework for unit testing the `Customer` class.

3. The `Bootstrap.java` file in `tutorial2/app` folder.
    * This file defines the `Bootstrap` class that annotated with `@OnApplicationStart` to mark it for execution at the start of the application.
    * The `Bootstrap` class also extends the `play.jobs.Job` to define code that is excuted asynchronously using the `doJob()` function.
    * This `doJob()` function is used to clean the database and create some sample objects.

4. A modified version of the `Application.java` file in `tutorial2/app/controllers` folder
    * This file defines the only __controller__ class `Application` in this project that extends the `play.mvc.Controller` class.
    * The `Application` class has only one action method `index()` that is called when a user visits the `http://localhost:9000` URL in browser. 
    * The `index()` method fetches all objects of `Account` and `Customer` classes from the database ands call the `render()` method with two lists (i.e. `accounts` and `customers`) as parameters.
    * The `render()` method executes the `tutorial2/app/views/Application/index.html` template and passes both lists to the template for generating the final HTML.

5. A modified version of the `index.html` file in `/tutorial2/app/views/Application` folder.
    * This file defines the __view__ template for generating the HTML that is displayed in browser when the `render()` method is called from the `index()` method of controller.
    * The default `#{welcome /}` is removed, instead the template checks whether `accounts` and `customers` lists are passed by `render()`.
    * In case both lists are available, the template renders each list as an HTML table; otherwise, the template renders empty response messages.

6. A modified version of the `main.css` file in `tutorial2/public/stylesheets/` folder.
    * This file defines the style of HTML elements used in all HTML templates.
    * This file is imported in the `main.html` files in `/tutorial2/app/views/` folder that serves as a parent template for other view templates. For example, the `index.html` files extends the `main.html` using `#{extends 'main.html' /}` tag.

7. A modified version of the `application.conf` file in `tutorial2/conf` folder.
    * This file defines the configration settings for the applictions.
    * The only changes line is `db=mem` that tells the appliction to use the in-memory database H2 for data storage. This configuration is required for the code in `Bootstrap.java`.


### Installation Notes:
1. Extract the zip file to your Eclipse workspace (or any other folder where you keep you projects). 
2. From the command line interface (CLI), i.e. `cmd` in Windows or `terminal` in Mac, navigate to the `tutorial2` folder and use `play run` or `play test` commands to test the application. 
3. Make sure that you have a working installation of Play Framework by checking that following envoriment variablse are correctly set.
    * Downlaod and install __Java 8 SDK__ from https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
    * Download and extract __Play Framework 1.5.2__ from https://www.dropbox.com/s/reiub03a1m7mlne/play1-1.5.2.zip?dl=0 
    * The `PATH` variable points to the `bin` folder of the Java SDK. You can test this by running `javac -version` command in CLI
    * The `PATH` variable also points to the Play Framework folder. You can test this by running `play help` command in CLI.
    * The `JAVA_HOME` variable points to the Java SDK folder. 