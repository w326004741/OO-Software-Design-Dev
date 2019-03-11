# CT548 OO Software Development - Assignment I

__Deadline: Wednesday, April 3, 2019__

## A web-based World Atlas with a Journey Planner
Based on the description of Assignment 1, extend your code to create a
web application with the functionality of a __world atlas__ with
a journey planner.

The basic functionality and travel rules remain the same as the Assignment 1,
except that this assignment is an implementation of the world atlas using
__Model-View-Controller__ design pattern.

The web application must be implemented in __Java__ using __Play Framework 1.5.2__.


#### Functional Requirements

Users of the web-based World Atlas must be able to:
1. List all the countries in a table.
2. Select a country from above table, to view its properties:
  * Its population and capital city.
  * List of all of its bordering countries.
  * List all the cities in the country and their properties.
3. Plan a journey between _any_ two cities (i.e. display at least one
  travel plan) as sequences of messages. For example:


    1. Travel from Barcelona to Madrid by bus
    2. Travel from Madrid to Berlin by plane

Administrators of the web-based World Atlas must be able to:
1. Login to the administration web-page.
2. Load the JSON data about countries and cities.
3. Manually create, update, and/or delete countries and cities.

#### Non-functional Requirements
Same as Assignment 1, except the application on need to import JSON from the
administration web-page.

#### Data Requirements
Same as Assignment 1, except you do not need to provide the data for
12 counties. Instead, you code will be tested with different combinations
of counties and cities.


#### Design Requirements
Same as Assignment 1, except following:

1. The application must allow administrator to upload JSON data files to
 import the details countries and cities in bulk.
2. The web-application must be implemented using Play Framework 1.5.2.
3. The web-application must store its data (from Model layer) in a
 database (H2 or MySQL).

## Submission Guidelines

The assignment solution must be uploaded to the Blackboard.
The solution must be delivered as a single archive (e.g. `zip`, `7z` or `tar.gz`) containing the following:

* The complete folder of source code for the Play application, including Java,
 HTML, CSS, YAML and all other relevant files.
  * Note: There is no need to include Play Framework with it.
* Correct configuration, i.e. files `conf` folder, including
 dependencies.
* A `README.md` file in project folder that describes your application for
 developers and users, including any instructions for running the application
 from source code, such as:
   * Software and package dependencies
   * Username and password for the administrator account.
   * Detail of the database connection.

### Evaluation

The default way for us to test your assignment will be as follows:

1. Setup the dependencies, as specified in your `README.md` file, using the
 `play dependencies` command in project folder.
2. Start the application using `play run` command in project folder.
3. Load the JSON data file using the administration web-page.
4. Verify the correctness of the complete solution by manual testing and
 running unit tests from `test` folder .

Note: Your source code __must compile and run__ from the project folder with
 all dependencies resolved either using the `conf/dependencies.yml` file or
 `.jar` files in the `lib` folder.
