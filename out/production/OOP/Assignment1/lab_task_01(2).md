# CT548 OO Software Development

## Guidelines for assignment submission

### Packaging assignment material

Close to the submission deadline, we will issue a file request for each student to upload their completed assignment to Blackboard or to an online drive directory. Each student will be allowed to add their own material to that directory _only once_, therefore make sure it is as complete as possible.

Your assignment must be delivered as a single archive (e.g. `zip`, `7z` or `tar.gz`) containing the following:

* UML class and use case diagrams: these should be provided as simple images (e.g. in `png` or `jpg` format). _In addition to that_ (and not instead), you can provide the source file of the tool you have been using to draw the diagram (e.g. StarUML or ArgoUML), but in that case you must specify the tool and version that you have used to create it.
* The source code, i.e. the files ending in `.java`, each in a directory corresponding to the package name where each class belongs.
* If you have used Maven to manage the build of your project, please also include its `pom.xml` file and any other necessary file.
   * Otherwise, the JAR files of any external libraries you have used must be included inside a `lib` directory in your project.
* If using data in files, the data file(s) in question.
   * If using a database instead, a dump of the database as a SQL script.
* a `README` file with any instruction you see fit for running the software (e.g. what is the class with the `main()` method, what external libraries and their versions are used if any, what filename, or what database name/username/password should be used for reading the data).

### Evaluation

The default way for us to test your assignment will be as follows:
1. Set up a Java project with your Java source packages in a `src` directory and any external dependencies in a `lib` directory, all included in the Java classpath
2. If a data file was used, place the file you have attached where indicated in the `README` file
3. If a database was used, set up the database using the parameters you provided in the `README` file and the attached SQL script for populating the database
4. Verify that the code compiles in standard Java 8 (if you used Maven, this will be done through `mvn install`): __not proceeding further if this step fails__.
5. Run the main class as specified in your `README` file
6. Verify the correctness of the solution
7. Verify the correspondence between the UML documentation and the actual implemented code
8. Evaluate the compliance of the solution with OO development principles
9. Attempt to extend the system where required (will test it through a separate `main()` method or unit test)

Your source code __must not require__ a specific development environment to run (i.e. do not hand in a code that only works on Eclipse, or only on NetBeans etc.). __Note that, if your assignment does not contain all the `.java` files or if your code does not compile, the assignment will be failed.__

Every extra step performed to make the program work entails a penalty.
Full points can be attained by performing only the mandatory (MUST) requirements without mistakes.
Fulfilling the optional (SHOULD) requirements awards extra points, which will complement any shortcomings in the mandatory requirements.

