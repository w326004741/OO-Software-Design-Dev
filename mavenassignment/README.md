# Maven Assignment
> Project: World Altas with Journey Planer  
> Module: OO Software Development   
> Lecturer: Dr Alessandro Adamou  
> ID: 18232813  

> By: [Weichen Wang](https://github.com/w326004741)

This project is a Maven project with data.json file as permanent data storage source file, Maven: org.json:json:20180813 as an external libraries. Implemented using the Strategy design pattern.

1. ITransportBehaviour.java: is Interface, internally defines a transportChoice(City, City) method.

2.  ByBus.java, ByTrain.java, ByPlane.java:  There are three subclass that implement the ITransportBehaviour Interface and Override the transportChoice(City, City) method from ITransportBehaviour Interface in three class to implement specific strategies.

3. This implement a Concrete Strategy Pattern (ITransportBehaviour, ByBus, ByTrain and ByPlane) and also implements a polymorphism.

4. JourneyLeg.java:  This class holds the ITransportBehaviour as a reference objet and use the reference object to call the specific strategy implement definition method. And create compareCountry(cityFromId, cityToId) method for the rules of traveling from one city to another and to judge whether two countries are bordering or not.

5. Driver.class: include main() method. (In the Driver.class, Right Click -> Click Run ‘Driver.main()’)

6. data.json: external libraries name is “Maven: org.json:json:20180813” in resource file
                      Path: mavenassignment/src/main/resources/data.json
                      link: https://mvnrepository.com/artifact/org.json/json/20180813


UML Tool:   ObjectAid UML Explore (https://www.objectaid.com/home)
The ObjectAid UML Explorer is an agile and lightweight code visualization tool for the Eclipse IDE.

Use Case Tool: Lucidchart online ( https://www.lucidchart.com)

