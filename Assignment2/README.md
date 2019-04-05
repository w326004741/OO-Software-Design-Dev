# CT548 OO Software Development - Assignment II
> Project: World Altas with Journey Planer with Play Framework      
> Module: OO Software Development   
> Lecturer: Dr UMAIR UL HASSAN      
> ID: 18232813  

> By: Weichen Wang

## Overview
The Assignment2 based on the Assignment1, extend Assignment1 code to a web application with the functionality of a world atlas with a journey planner. 


## How to use this project:
1. Decompression the `Assignment2.zip`
2. Enter your Terminal(for mac) or CMD(for windows), and following below:

```
# Change directory to Assignment2 
cd Assignment2

# to resolve dependencies of required modules or libraries as specified in dependencies.yml
play dependencies

# to run the application
play run   -> and then you can open browser enter: 'localhost' to access the webpage of this application.
```
3. Other play commmands:
* `play eclipsify` to generate file for Eclipse IDE
* `play idealize` to generate files for IntellJ Idea IDE
* `play test` to run the application in test mode
* `play clean` to remove temporary files (compiled classes, uploads, etc)
* `play help` to list all possible commands

## About Project:
##### Model Layer: 
- City.java & Country.java extends Model and add @Entity Annotation as a Entity Class, represent the underlying data structure and business logic of a Web application
- GetWay.java: is an abstract class, internally defines an appendWay() method.
- Bus.java, Train.java, Plane.java: There are three subclass that extends the GetWay Abstract class and Override the appendWay() method from GetWay Abstract Class in three class to inherit specific strategies. 
- This implement a Concrete Strategy Pattern (GetWay, Bus, Train and Plane) and also implements a polymorphism.

##### Controller Layer:
- Application.java & CountryLoader.java: handles incoming HTTP requests and uses the model and view to build and return a response.
- Application.java: 
    - index() method for Home Page and list all the countries in a table
    - show() method for view countries properties, list of all of its bordering countries and List all the cities in the country and their properties.
    - check() & planJourney() for Journey Planner
- CityController.java & CountryController.java: administration web page.
- CountryLoader.java: for upload JSON file and get data of JSON file.
- PlannerProcess.java: is a utility class that provides algorithmic support for the Journey Planner.

##### View Layer:
- /view/Application: provide the corresponding HTML page for the methods in Application.java. such as: index(), check(), show().
- /view/CountryLoader: provide the corresponding HTML page for the loader() method in CountryLoader.java.

##### Dependencies:
- play
- org.json -> json 20180813
- play -> crud
- play -> secure

##### Detail of the database connection.
- db = mem (for a transient in memory database (H2 in memory)) 

##### Username and password for the administrator account.
- Username: Weichen
- Password: 12345

    



 

