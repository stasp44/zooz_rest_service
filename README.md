---
Zooz rest service version 0.1 23/06/2017

Service
=======
(REST) Service based on Spring mvc and Tomcat server which offers an interface to data contained in stripe third party service.
+ current version allows to get a list of payment charges by filters.
 + ### available filters
    * createdDate - get the transaction that occur on the specific date(use UNIX timestamp)
    * customerId - get the transactions for a specific user
    * limitTransactions - limit number of transactions(default value is 10)

     *you can use several filters in the same request. Use ';' for delimiter

Configuration Files
==================
+ application.yaml
    * apiKey = {stripe api token}

Installation
==================
+ Best to use IntelliJ IDE and Maven to run and build the project

Usages
==================
+ get all your recent charges -> http://localhost:8080/charges
+ get charges with filters -> http://localhost:8080/charges?filters=filter(createdDate,1498238165);filter(customerId,1)

