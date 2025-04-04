# Introduction
A backend application, using java and springboot, that tracks registered users in high traffic areas and delivers a drink to them within a short time frame.



## About
* The application was built using Java 17

* Database was done using postgresql.
* Kafka was used to assign user request to a rider and together with websockets it was used to track user location (temporarily) in real time.
* App was packed into a jar file and containerised using docker. 

## Prerequisites
* Java 17
* Maven
* Docker
* Kafka
* Websocket
* Maven

## Setup
Clone the repo
[https://github.com/EkeneU/RushHourRescue.git]

Setup kafka on your system and make sure that the kafka server is up and running

Run the tests
`./mvnw clean test`

Build the application
`./mvnw clean build`

Start the application
`java -jar RushHourRescue-0.0.1-SNAPSHOT.jar`

The application should start on port 8080

## Building the Docker Image
CD into the root directory of the docker compose.yml file

Create the app container
`docker-compose up -d`


## Available Endpoints

  * POST - http://localhost:8080/api/dispatch/create (Creates a user request)
  * PUT - http://localhost:8080/api/dispatch/assign (Assigns a user request to a dispatch rider)
  * PUT - http://localhost:8080/api/location (Temporarily updates user location)
    
