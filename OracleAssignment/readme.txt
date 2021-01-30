
install dependencies:
	gradlew clean install
above command will install required dependencies.
List of dependencies:
	- okhttp for http calls
	- jackson for serializations


build program:
	gradlew build

run your program, with example commands on how to run it if necessary:
 
	- after building the dependencies, program can be executed using gradle as follows
	gradlew run -q --console=plain (in application path)
