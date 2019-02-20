java -jar jacoco/jacococli.jar dump --port=36321 --address=localhost --destfile=result.exec

java -jar jacoco/jacococli.jar report result.exec --classfiles=./target/classes --sourcefiles=./src/main/java --html report