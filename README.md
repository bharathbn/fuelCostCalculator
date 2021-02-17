# fuelCostCalculator

This project provide the service end point to send the Events periodically and calculate the total fuel cost and store it in db.


Features of the project
1. Fuel Event can be triggered using API with request body shared in this doc. 
2. Fuel calculation will be stored in DB and can be fetched using API
3. Caching has been introduced and This will cache the fuelprice from Thirdparty for 24hrs.
4. security class has been introduced and This validate the API_KEy value in each request.
5. Above application has been made dockerzied so that shipment can be done easily 

----------------------------------------------------------------------------------------------------------------------------------

This project used 
1. Maven
2. spring boot - web
3. spring boot - Security
4. spring boot - jpa
5. RabbitMQ - Messaging Queue (docker image)
6. Redis -  Caching  (docker image)
7. Hitting 3rd party API through RESTTemplate - https://www.newsrain.in/petrol-diesel-prices/near-lat-long/13.00288/76.10245 
  (https://www.newsrain.in/petrol-diesel-prices/near-me)
  
  
----------------------------------------------------------------------------------------------------------------------------------

How to Run:

Download the project and navigate inside the project folder and run below docker commands

1. 
      docker image build -t benz-fuelcalculator
      
      Docker-compose up 

OR

2. 
    docker run -d -p 6379:6379 --name benzredis redis
    
    docker run -it -d -p  15672:15672 -p 5672:5672 rabbitmq:3-management
    
    mvn clean install
    
    mvn spring-boot:run

OR

3.
    Download the project and import it in spring STS and click on Run as SpringBoot application


----------------------------------------------------------------------------------------------------------------------------------

APIs Details:


1. http://localhost:8080/fuelCostCalculator/v1/fuelevent 

    Method : POST

    Headers : 

      userId:Bharath (user can add his id)

      API_KEY:Password1

      Content-Type:application/json

    Body:

      {
        
        "eventValue" : false,

        "cityName" : "Hassan"
      }

    Response : 

      Success - 202 Accepted 

      No API key -  400 Client Auth error.
 
2. http://localhost:8080/fuelCostCalculator/v1/fuelcost  

    Method: GET

    Headers:

      userId:Bharath (user can add his id)

      API_KEY:Password1

    Response : 
     Success - 200 response body with JSON Array 

     No API key -  400 Client Auth error.

 
 ----------------------------------------------------------------------------------------------------------------------------------
 
 




