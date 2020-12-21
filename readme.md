Maven is a project/dependency management and project building tool.

Why? What problem?
number 1 problem maven solves:
before maven java developers had to manually download all required libraries and import them to the project.
ok , you do that only once right? if you're the only dev then yes, but if you're sharing your code with other devs they need to redo the same program
which is download and import to the project

Maven solves that with dependency management wich is an automatic process of downloading the specified libraries to your local machine. And importing them to the your project.
in order to change version of a library all it takes is just to change version number in pom.xml 

number 2 problem solved in maven: 
as a dev you need to create jar files of a java project which is the final artifact that is executed by.
so it has many manual steps if done without maven. steps are to compile, if your keep transfering those files with the project.

in maven it includes all resources in jar file.
also maven helps you push your project new version to remote repository automatically.


we can compile and create jar files using maven goals.
maven goals(lifecycle) are the following:

clean -> it cleans(deletes) target folder

validate -> make sure all dependencies are loaded

compile -> compiles all of the classes and resources and puts them in target folder

test -> runs all tests.(surefire or fail-safe plugins). if no plugins are specified maven will run all tests that are defined under src/test/java

package -> will create jar file of the project in target folder 

verify -> will generate reports of test run.

install -> pushes jar file from taget folder to local repository , aka .m2 folder.

deploy -> pushes jar file from local maven repository to remote maven repository.

what is local maven repository?

what is remote maven repository? 


jar file -> is a compressed file of this project. one executable file that is a program
porpose i to hide all code from being visible to others and only allow them to run your program

zip file ->its purpose is to compress and make a file light on memory