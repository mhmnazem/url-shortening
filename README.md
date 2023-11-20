# URL Shortening application

### Description
This URL shortener is a simple yet powerful service built with Spring Boot. It allows users to shorten long URLs for easier sharing and management. Featuring a modern Kotlin-based architecture, this application is easy to use and integrates Swagger for API documentation and testing.
### Getting Started
These instructions will help you set up and run the application on your local machine for development and testing purposes.

### **Technologies**
* Spring Boot 3.1.5
* Kotlin 1.8.22
* Java 17
* Maven
* SpringDoc OpenAPI (Web MVC UI and Kotlin)
* H2 as in memory Database
* Junit
* Mockito


### **Installing**
#### clone the repository:<br>
* git clone https://github.com/mhmnazem/url-shortening.git


### Building the Application
To build the application, follow these steps:

* Ensure you have Maven, Kotlin and Java 17 installed.
* Clone the repository to your local machine.
* Navigate to the project directory and run mvn clean install to build the project.
* To start the application, run mvn spring-boot:run.

### Run
The application runs on port 8080 by default. You can access various components of the application as follows:

* Swagger UI:
  * For API documentation and testing, visit http://localhost:8080/swagger-ui.html. This interface provides a user-friendly way to explore and test the API endpoints.

* H2 Database Console:
  * The H2 console for database management is available at http://localhost:8080/h2-console. This console is useful for direct interaction with the in-memory database.

### Logic

#### Generating Hash Code for a URL
#### Input Processing: The service receives an original URL.
* Validation: The URL is checked for validity.
  * If valid, it proceeds to identifier generation.
  * If invalid, returns HTTP status 400 (Bad Request).
* Hash Code Generation:
  *  The URL is mapped to a unique hash code using the JVM's default hashCode() function.
  * Checks for an existing hash code for the same URL.
    * If it exists, returns the existing hash code.
    *  If not, generates a new hash code.
#### Retrieving URL Associated with a Hash Code
* Input Processing: The service receives a hash code as input.
    * URL Retrieval:
      * If a URL is associated with the provided hash code, it is returned.
      * If no URL is associated, appropriate exceptions are thrown.
      returns HTTP status code 404 (Not Found) when the URL is not found.
  
### What is next! 
In its current phase, the project serves as a minimum viable product (MVP) and operates effectively using an H2 in-memory database. However, for a production-ready solution, especially considering global scalability and deployment across multiple environments, several enhancements are suggested:

* Transition to a Persistent Database: Implementing a persistent database like PostgreSQL or MySQL for data durability and scalability.
* Mapping Shortened URLs to IDs: Optimizing URL lookup by mapping shortened URLs to IDs and vice versa.
* Hash code customised generation: Customising how the hash code can be generated based on different requirements in order to have a robust code.
* Dockerization: Containerizing the application with Docker for easier deployment and environment consistency.
* Implement Caching: Introducing caching mechanisms to reduce database query load and improve response times.
* Monitoring Tools: Utilizing tools like Prometheus and Grafana for real-time monitoring and alerting.
* Enhanced Security: Implementing security measures, including input validation, authentication, and authorization.