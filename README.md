Drools Demo
===

Course planner application for demonstrating Drools use-cases and configuration.
This drools demo version uses Drools Workbench containing the rules file to be used for the application.
This application is a web service using Spring.


## Build the application:

    mvn clean install

## Run the application:

    mvn spring-boot:run

## Get Suggested Course/s:

    http://localhost:9999/suggest

## Sample Payload:
    {
    "items": [{"subject": "math", "rating": 10}, {"subject": "physics", "rating": 10}]
    }
