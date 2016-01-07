Drools Demo
===

Course planner application for demonstrating Drools use-cases and configuration.
This drools demo version uses a remote-based rules file thru the use of Drools Workbench (Wildfly as app server).
This application is a web service using Spring.

## Install/Setup Drools Workbench
- Install [Wildfly](https://docs.jboss.org/author/display/WFLY8/Getting+Started+Guide) (application server)
- [Setup Drools Workbench](https://docs.jboss.org/drools/release/6.0.0.Final/drools-docs/html/wb.Workbench.html)
- Generate jar from drools-facts module
    ```
    $ mvn clean install
    ```
- Upload/Add generated JAR file in Artifact Repository of Drools Workbench
- Add the uploaded JAR file as dependency of the project you created in Drools Workbench. Make sure to save, then build and deploy the added dependency
- Create rules file in Drools Workbench (I've added a sample rules file, course_suggestion.drl). Validate the rules file you created.
- Go to Artifact Repository and get the path of the generated JAR of your project. Replace the path in *drools-app/src/main/resources/com/drools/configs/drools-app.properties*

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
