# URL Shortening application

### Description
This URL shortener is a simple yet powerful service built with Spring Boot. It allows users to shorten long URLs for easier sharing and management. Featuring a modern Kotlin-based architecture, this application is easy to use and integrates Swagger for API documentation and testing.
### Getting Started
These instructions will help you set up and run the application on your local machine for development and testing purposes.

### **Technologies Used**
* Spring Boot 3.1.5
* Kotlin 1.8.22
* Java 17
* Maven
* SpringDoc OpenAPI (Web MVC UI and Kotlin)
* H2 as in memory Database
* Junit & Mockito for Testing

### Getting Started
#### Prerequisites
* Java 17
* Maven
* Kotlin


### Installation
* Clone the repository:
    * git clone https://github.com/mhmnazem/url-shortening.git


### Building the Application
To build the application, follow these steps:
* cd url-shortening
* mvn clean install
* mvn spring-boot:run

### Accessing Application Components
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
#### Retrieving URL Associated With a Hash Code
* Input Processing: The service receives a hash code as input.
    * URL Retrieval:
      * If a URL is associated with the provided hash code, it is returned.
      * If no URL is associated, appropriate exceptions are thrown.
      returns HTTP status code 404 (Not Found) when the URL is not found.
  
### Scalability And Maintenance

This application contains two APIs first to generate identifier for the specific URL and second for retrieving URL from existing Identifier.
After globalisation, the second API is going to be called more often because it is going to be mapped to the Shortened URL which is shared by users for their audience.

* Scalability and maintenance are recommended by:
  * Optimized for high-traffic scenarios through performance tuning.
  * Utilizes caching and load balancing to manage increased loads efficiently.
  * Planned Upgrades:
    * Integration of a robust, persistent database like PostgreSQL.
    * Implementation of a Content Delivery Network (CDN) for faster, global content delivery.
    * Strengthening security measures to safeguard data and services.

### Next Steps!

* Migrating to a persistent database like PostgreSQL.
* Implementing advanced caching strategies.
* Dockerizing the application for easy deployment.
* Establish a CDN to minimize latency and improve user experience worldwide.
* Implementing robust security features.
* Implement detailed monitoring and logging to ensure system health and facilitate quick issue resolution.
* Develop cost-efficient strategies for scaling resources in line with demand.