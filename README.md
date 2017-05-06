# spring_angular_workshop
Modern Java Stack - Lunatech Workshop

1. Required Installations:
  - brew install maven
  - brew install mongodb
  
2. Create directory for the mongo database on file system: /DB
  - open this directory via Terminal and execute mongod -dbpath=.
  - copy the drinks.csv file from the project's resources directory in the same DB directory
  - to import the data, execute mongoimport -d test -c alcohol_consumption --type csv --file drinks.csv —headerline
  
3. Start the application with the Terminal command mvn jetty:run

