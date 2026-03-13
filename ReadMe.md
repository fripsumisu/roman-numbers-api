# Roman Numerials API

![alt text](http://static.tumblr.com/5nbl396/VRomeu5l2/read-write-roman-numerals-200x200.jpg "Roman Numbers") 

Ever wanted to quickly check what the year of your birth would be in old school Roman numerals? Well this is just the API.
A bit of fun wrapped by a very simple ReSTful API interface.

## Building the project
Clone, CD to the project root with the pom.xml and simply run ```mvn verify``` to run the unit and integration tests.

## Running the project locally
The application uses the Spring-Maven plugin.
Launch the application via _maven_ or via your IDE, and once Spring Boot has launched point your browser, or _curl_ to http://127.0.0.1:8080/roman/ adding the standard Arabic number you which to convert to Roman numeral format.
```shell
$ curl http://127.0.0.1:8080/roman/2026
{"arabicNumber":2026,"romanNumber":"MMXXVI"}
```