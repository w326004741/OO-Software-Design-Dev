## EXERCISE I (Jan 23-28)
```
    TV series           Season               Episodes (🙂)
    - title(always)     - title of series   - title of episodes
    - running time      - running time      - running time (mins) 接口
    - list of episodes  - number            - number // 独立
    - list of season    - list of episodes  
```

Design (using UML class diagrams) and implement (in Java) a data management system for TV series. This system will provide functionalities for querying it for information about series(string), seasons(int) and episodes(int). This version of the system will operate in-memory (i.e. without a database or filesystem backing it). 设计（使用UML类图）并实现（在Java中）用于电视剧的数据管理系统。该系统将提供查询系列，季和剧集数信息的功能。该版本的系统将在内存中运行（即没有数据库或文件系统支持它）。


### REQUIREMENTS

#### Functional requirements
1. The system must be able to provide information about __series__, __seasons__ and __episodes__, treating them as distinct categories
2. For any of these types, the system must be able to tell the user:
    - the __running time__ (in minutes)
3. For Series and Episodes, the system must also be able to:
    - answer the question whether it has a __title__ or not
    - retrieve the title in question, if present
4. For Seasons and Episodes, the system must also be able to retrieve:
    - the __number__ (in order of original airing)      按照原始播出的顺序
    - the __title of the series__ they are part of      他们所属的系列的__title
5. For Series and Seasons, the system must also be able to:
    - list all the episodes in order                    按顺序列出所有剧集(ArrayList)

#### Non-functional requirements
* It MUST be possible to create episodes with as well as without a title
* The system MUST NOT crash if an episode does not have its own title (i.e. they are just known as episode 1, 2,...)
* The series title or episode number MUST NOT be part of the episode title (series tilte or 集数不在集的title内)
* There CANNOT be episodes without seasons, nor seasons without series (no season(季) no episodes(集), no series(系列) no season(季) （组合composition 关系 HAS-A）
* Running times MUST be consistent: a series is of the exact same length as its seasons combined, and a season is of the exact same length as its episodes combined

#### Data requirements
* The number of seasons/episodes is irrelevant for the classification of series i.e. there are no mini-series or pilot (non-season) episodes
* Also it does not matter if the series airs on TV and/or on the Web
* You may use http://imdb.com as a reference for the testing data
* Also you can make up and invent season numbers or titles of episodes as needed 


### RESTRICTIONS
1. The methods for getting the title, number, running time, title of parent series etc. SHOULD have the same signature (i.e. name + ordered list of parameter types if any) for all the classes that provide them
2. You CANNOT manually compute or enter the running times of seasons and series.
3. _Don't repeat yourself_ if you can avoid it (sometimes you might not be able to).


### VALIDATION
* Write code that creates a few instances of all the classes (e.g. _Black Mirror_, _Twin Peaks_ season 2, _The Simpsons_ s20ep1), but always respect the composition rule!
* For each item in functional requirements 2 to 5, add example code that demonstrates that these requirements are fulfilled.
* It's enough to put all this in the `main()` method of the application.

