## EXERCISE II (Jan 30 - Feb 4)

Improve upon the existing TV Series guide that you have developed in Exercise I, both from a _functional_ perspective - i.e. by implementing additional features - and from a _design_ perspective - by refactoring the existing code to make it more flexible and extensible.


### REQUIREMENTS

In addition to existing requirements:

#### Functional requirements

1. The system must also support (and distinguish between) __live-action__ series (_Black Mirror_, _Diff'rent Strokes_) and __animated__ series (_The Simpsons_, Japanese anime etc.).

2. Include support for full-length __feature films__ that are spin-offs of film series (e.g. _Black Mirror: Bandersnatch_, _X-Files: I want to believe_).
   - The relationship between a series and a film must be explicit (i.e. one must be able to ask the system for the list of spin-off films of a TV series).
   - Feature films, like episodes, have a title and a running time, but are not part of a season
   - Like the series, they can be live-action or animated (e.g. _The Simpsons Movie_). Sometimes, they can even cross over as live-action spin-offs of animated series (e.g. _Casshern_, the _Transformers_ movies) or vice versa.

3. For each TV series or spin-off movie, the user must be able to retrieve the __production company__ that made it (e.g. Netflix, Fox, Endemol...), and for each production company list all the media (series or movies) that it produced.

4. Create a `MediaCatalogue` (or similarly called) class, if you haven't already, which is able to list all the series and all the feature films that were derived from each.

5. If possible, try to make the program able to __persist__ its data, i.e. read/write the data about series etc. locally (e.g. from a file in CSV or JSON format, a MySQL database, your choice...)

#### Non-functional requirements

1. It must not be possible to create a "plain" TV series or movie that is neither animated nor live-action.
2. Spin-off films are _not_ part of a TV series in the strict sense of composition: another custom type of relationship must be used (Hint: they belong in the same fictional universe...)
3. You can either consider a production company to be an aggregation (weak composition) of the media that it produces, or define a custom relationship for that too
4. The `MediaCatalogue` must be unique and globally accessible.

#### Data requirements
1. There should be no movies that are not derived from a TV series.

#### Design requirements

1. There must be at least one demonstrated case of polymorphism involving the types (classes or...) that you have defined for your software.
2. The method to get the running time of series, seasons, episodes and films MUST be the same across all these types (in the definition, whereas the implementation can be different).
3. The methods to get the title of the object being inspected (series, episode or movie) SHOULD also share the same method definition if possible. 
    
As usual, first draw the (updated) UML class diagram, then while you code the solution also use a `main()` method to test the requirements.