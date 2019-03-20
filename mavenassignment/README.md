{\rtf1\ansi\ansicpg936\cocoartf1671\cocoasubrtf100
{\fonttbl\f0\froman\fcharset0 Times-Roman;\f1\froman\fcharset0 Times-Bold;\f2\froman\fcharset0 TimesNewRomanPS-BoldMT;
\f3\froman\fcharset0 TimesNewRomanPSMT;\f4\fswiss\fcharset0 Helvetica-Bold;\f5\fswiss\fcharset0 Helvetica;
\f6\fnil\fcharset134 STSongti-SC-Regular;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
{\*\listtable{\list\listtemplateid1\listhybrid{\listlevel\levelnfc0\levelnfcn0\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{decimal\}.}{\leveltext\leveltemplateid1\'02\'00.;}{\levelnumbers\'01;}\fi-360\li720\lin720 }{\listname ;}\listid1}}
{\*\listoverridetable{\listoverride\listid1\listoverridecount0\ls1}}
\paperw11900\paperh16840\margl1440\margr1440\vieww17920\viewh15900\viewkind0
\deftab720
\pard\tx10800\tx10800\pardeftab720\sl280\qc\partightenfactor0

\f0\fs48 \cf0 \expnd0\expndtw0\kerning0
README\
\pard\tx10800\tx10800\pardeftab720\sl280\qc\partightenfactor0

\fs36 \cf0 Project: World Altas with Journey Planer
\fs48 \

\fs36 Module: OO Software Development\
Lecturer: Dr Alessandro Adamou\
ID: 18232813\
\pard\pardeftab720\sl280\qc\partightenfactor0
\cf0 By: Weichen Wang\
\pard\pardeftab720\sl280\partightenfactor0
\cf0 This project is a 
\f1\b Maven
\f0\b0  project with 
\f1\b data.json
\f0\b0  file as permanent data storage source file, 
\f2\b \kerning1\expnd0\expndtw0 Maven: org.json:json:20180813
\f3\b0  as an external libraries. Implemented using the 
\f2\b Strategy design pattern
\f3\b0 .\
\pard\pardeftab720\sl280\partightenfactor0

\f2\b\fs24 \cf0 \
\pard\pardeftab420\li360\fi-360\partightenfactor0
\ls1\ilvl0
\f4\fs36 \cf0 1. 
\f2 ITransportBehaviour.java: 
\f3\b0 is
\f2\b  
\f3\b0 Interface,
\f2\b  
\f3\b0 internally defines a transportChoice(City, City) 
\f5 method
\f3 .\
\ls1\ilvl0
\f2\b \
2.  ByBus.java, ByTrain.java, ByPlane.java:  
\f3\b0 There are three subclass that implement the ITransportBehaviour Interface and Override the transportChoice(City, City) method from ITransportBehaviour Interface in three class to implement specific strategies.\
\
\ls1\ilvl0
\f2\b 3. 
\f3\b0 This implement a Concrete Strategy Pattern (ITransportBehaviour, ByBus, ByTrain and ByPlane) and also implements a polymorphism.\
\ls1\ilvl0
\f2\b \
4. JourneyLeg.java:  
\f3\b0 This class holds the ITransportBehaviour as a reference objet and use the reference object to call the specific strategy implement definition method. And create compareCountry(cityFromId, cityToId) method for the rules of traveling from one city to another and to judge whether two countries are bordering or not.\
\ls1\ilvl0
\f2\b \
5. Driver.class:
\f3\b0  include main() method. (In the Driver.class, Right Click -> Click Run \'91Driver.main()\'92)\
\
\ls1\ilvl0
\f2\b 6.
\f3\b0  
\f2\b data.json
\f3\b0 : external libraries name is \'93Maven: org.json:json:20180813\'94 in resource file\
                      Path: mavenassignment/src/main/resources/data.json\
                      link: {\field{\*\fldinst{HYPERLINK "https://mvnrepository.com/artifact/org.json/json/20180813"}}{\fldrslt https://mvnrepository.com/artifact/org.json/json/20180813}}
\f2\b \
\pard\pardeftab420\li360\fi-360\ri720\partightenfactor0
\ls1\ilvl0\cf0 \
\pard\pardeftab420\ri720\partightenfactor0
\cf0 \
\pard\pardeftab420\partightenfactor0
\cf0 UML Tool:   
\f3\b0 ObjectAid UML Explore ({\field{\*\fldinst{HYPERLINK "https://www.objectaid.com/home"}}{\fldrslt 
\f5 https://www.objectaid.com/home}})\
The ObjectAid UML Explorer is an agile and lightweight code visualization tool for the Eclipse IDE.\
\
Use Case Tool: Lucidchart online 
\f6 (
\f3  {\field{\*\fldinst{HYPERLINK "https://www.lucidchart.com"}}{\fldrslt https://www.lucidchart.com}})
\f2\b\fs24 \
\pard\pardeftab420\ri720\partightenfactor0

\f3\b0 \cf0 \
}