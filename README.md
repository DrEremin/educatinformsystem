# Information system of education system

***

## Description

This project is a layout of an information system. The objects of this system<br>
are students and universities. The third party are statistics objects which<br> 
contain generalized data both on students, and on universities. Since the<br> 
project is a training, it contains several classes with the main() function,<br> 
which must be switched in order to run different versions of the program. To<br>
configure logging, specify -Djava.util.logging.config.file=<br>
/absolute path to file/log.properties in the virtual machine options.<br>
Classes containing the main() function are AppModule33, AppModule33,<br>
AppModule34, AppModule35, AppModule37. Descriptions of a functional are in the<br>
comments to these classes in the files themselves<br>

***

## Used technologies

This project uses the following features:<br>
+ working with comparators and streams;<br>
+ using configured logging using java.util.logging and the file .properties;<br>
+ serialization and deserialization to json using a library Gson;<br>
+ parsing a file in .xlsx format using Apache POI library and assembling<br> 
objects based on the information received as a result of parsing;<br>
+ creating a file .xlsx and writing the necessary information into it in the<br>
required form based on POJO using Apache POI library;<br>
+ creating файлов (documents) .json and .xml with required structure and naming<br>
fields based on DTO using Gson and JaxB libraries.