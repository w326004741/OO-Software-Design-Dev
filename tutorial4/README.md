# Code for Tutorial 4 of Play Framework 

This project contains extended code from the Play Framework tutorial in lab on __Wednesday, March 27, 2019__.

### Overview of code changes
The project contains following changes compared to the `tutorial3.zip` code provided earlier.


1. A modified version of the `dependencies.yml` file in `tutorial4/conf` folder.
    * This file defines the Play Framework module needed for this application.
    * This version has following changes
        * Adds `- play -> secure` line to include Security module to the application
        * Adds `- org.json -> json 20180813` line to include org.json library from https://github.com/stleary/JSON-java
        * Removes `- play -> docviewer` line to remove Play documentaton module
    * You must run the command `play dependencies` to enable the application to load or remove modules. 

2. Modified versions of CRUD controllers in the `tutorial4/app/controllers` package.
    * Both `Customers.java` and `Accounts.java` contain respective classes to use the generic CRUD views and actions methods.
    * Both class extend from `CRUD` class that is part of the admin module.
    * Both classes are annotated with `@With(Secure.class)` to ensure that the controllers required authentication.
    * This allows `http://localhost:9000/admin/` URL to redirect to the login page if user is not authenticated.
    * By default, Play accepts any combination of username and password for authentication.

3. Modified versions of model classes in the `tutorial4/app/models` package.
    * All the `private` variables of the `Account` and `Customer` classes has been changes to `public`.
    * This is needed for admin module to work properly.

4. A new view in the `tutorial4/app/views/CustomLoader` folder.
    * The `loader.html` defined the HTML form for allowing a user to upload a JSON file.
    * The form also includes a checkbox for user to indicate whether to clear the previous data from the application on file upload.

5. A new controller in the `tutorial4/app/controllers` package.
    * This `CustomLoader.java` controller is created to provide new action methods.
    * The controller is secured using `@With(Secure.class)` annotation.
    * Contains the `loader` action method that renders the `loader.html` view.
    * Contains the `uploadJSON` action method that recieves data from HTML form in `loader.html`.
    * Contains the `populationDatabase` method that parses the JSON file, creates relevant objects, and saves them in database.


### Installation Notes:
1. Extract the zip file to your Eclipse workspace (or any other folder where you keep your projects). 
2. From the command line interface (CLI), i.e. `cmd` in Windows or `terminal` in Mac, navigate to the `tutorial2` folder and use `play run` or `play test` commands to test the application. 
3. Make sure that you have a working installation of Play Framework by checking that following environment variables are correctly set.
    * Downlaod and install __Java 8 SDK__ from https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
    * Download and extract __Play Framework 1.5.2__ from https://www.dropbox.com/s/reiub03a1m7mlne/play1-1.5.2.zip?dl=0 
    * The `PATH` variable points to the `bin` folder of the Java SDK. You can test this by running `javac -version` command in CLI
    * The `PATH` variable also points to the Play Framework folder. You can test this by running `play help` command in CLI.
    * The `JAVA_HOME` variable points to the Java SDK folder. 
4. Use `play dependencies` command to resolve dependencies before running or testing the application.