# fuelCostCalculator

This project provide the service end point to send the Events periodically and calculate the total fuel cost and store it in db.

This project has dependency on 
1. Maven - spring boot
2. RabbitMQ (runnign docker image)
3. Redis (running docker image)
4. Hitting 3rd party API through RESTTemplate - https://www.newsrain.in/petrol-diesel-prices/near-lat-long/13.00288/76.10245 
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

      userId:Bharath

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

      userId:Bharath

      API_KEY:Password1

    Response : 
     Success - 200 response body with JSON Array 

     No API key -  400 Client Auth error.

 
 ----------------------------------------------------------------------------------------------------------------------------------
 
 




