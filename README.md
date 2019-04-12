# mongoDB
This is my mongodb database that I created using java to connect to compose for mongodb hosted by ibm cloud. This project was created for my senior design project in which we were tasked to store warranty and trust deed objects for use when buying a property. Other members of my group have other parts in the project but my task was to create a database and a database manager class which would allow for the objects to be stored.

The mongoDB DatabaseManagerAPI file has three get functions which allow members of my group to search the database based off what they want to search for. If the object is inside of the database, then it goes and fetches it from the database. If it is not there, then it returns null. 

The mongoDDatabaseManger has the create client function which connects to the database and stores the actual objects. It also has a getall function which is used for searching the database. It is called in the get functions in the databaseManagerAPI file.
