# CT548 OO Software Development - Assignment I

__Deadline: Tuesday, Feb 26, 2019__

## Programming a World Atlas with a Journey Planner

Design (using UML class and use case diagrams) and implement (in Java 8) a software system that realises a _world atlas_, i.e. a catalogue of countries, cities and points of interest within a city. As a special feature, this world atlas will also be able to tell the user how to travel from city to city - a rudimentary journey planner.

The world atlas has several countries. Every country is bordered by some countries but not others. For example, Ireland is bordered by the UK but not by Germany.

Each country has many cities but only one capital city. The capital also happens to be the only city in that country that has an airport.

Therefore, travelling from one city to another must follow these rules:
1. if between cities within the same country, take a bus
2. if between cities in bordering countries, take the train
3. if between cities in non-bordering countries, travel by plane through their corresponding airports

Of course, combinations may be necessary, and multiple alternative journey plans may come up. For example, if I want to travel from Barcelona to Berlin, I may either take the bus to Madrid and from there the plane to Berlin, or the train from Barcelona to Lyon and then another train from Lyon to Berlin.

This application will not have a graphical user interface (GUI). It will work from the command line. The names or IDs of the two cities to travel between should be provided by the user, either as arguments to the main method, or through interactive user input.

### Requirements

#### Functional Requirements

The World atlas MUST be able to:
1. List all the countries
2. For every country, list the bordering countries and answer the question whether two countries are bordering or not
3. Retrieve the population of a city or country
4. List all the cities in a country, or retrieve only the capital
5. For _any_ two cities, print at least one travel plan, as sequences of messages of the form: ``Travel from [city_A] to [city_B] by [means_of_transport]``. An example two-leg trip is as follows:


    Travel from Barcelona to Madrid by bus
    Travel from Madrid to Berlin by plane

Each functional requirement must be demonstrated by executing the `main` method of your application.

#### Non-Functional Requirements

1. The population of a country MUST be greater or equal than the combined populations of its cities - it MAY be greater if we take rural areas into account. Rural areas need not be modelled.
2. The journey planner MUST prioritise (i.e. print first) the journey plans with the lower number of legs.
3. If there are many possible journey plans with the same number of legs, the journey planner SHOULD prefer the plan that includes flying, if any.
4. Persistence: countries cities and capitals SHOULD be read from permanent storage, such as a plaintext file, JSON or SQL database.

#### Data Requirements

1. The geographical coordinates of a city are irrelevant
2. Provide at least 12 countries, each with at least 2 cities. For each country, there MUST be at least one non-bordering country
3. All the cities of bordering countries are pairwise reachable by train
4. You can travel by plane between the capitals (and only the capitals) of every country

#### Design Requirements

1. The selection of the means of transport MUST be implemented using the __Strategy design pattern__ (therefore assigned at runtime to each leg of the journey).
2. There MUST be at least one case of __Polymorphism__ with the classes created for the system.
3. If I want to __extend__ the system to support other types of places (e.g. regions, continents) I MUST be able to do so __without modifying__ the existing code.
4. If reading from permanent storage, you SHOULD use an existing deserializer or MySQL driver. Examples:
   * JSON format support: https://mvnrepository.com/artifact/org.json/json
   * MySQL connector: https://mvnrepository.com/artifact/mysql/mysql-connector-java

---

__MySQL__ users: suggestion for a relational table model (`*` denotes primary key, `+` denotes foreign key)

    categories : *cat_id name	     (names are e.g. "city", "country"...)
    places : *place_id +cat_id name population
    capitals : +place_id +place_id	 (first key is country, second is capital)
    contains: +place_id +place_id	 (country, city)
    bordering: +place_id +place_id   (country, country)

__JSON__ users: suggestion for a sample data file.

    {
      "countries" : [{
          "id" : 1,
          "name" : "Ireland",
          "cities" : [{
              "id" : 101,
              "name" : "Dublin"
          },{
              "id" : 102,
              "name" : "Galway"
          }],
          "capital" : 101
      },{
          "id" : 2
          "name" : "United Kingdom",
          ......
      }],
      "bordering" : {
          1 : [2],
          2 : [1],
          3 : [4, 5]
          ......
      }
    }

If you want you can also use a separate array of categories with their IDs, like in the MySQL example schema.

These are only indicative. The data schema/quality will not affect your grading as long as it does not affect the application and respects the constrains defined in the data requirements. However, __do hot hardcode journey plans inside the data__!