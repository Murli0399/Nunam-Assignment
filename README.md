# Nunam-Assignment

A Spring Boot application that allows users to track GPS data for their vehicles and calculate the distance traveled between two dates based on the stored GPS coordinates.

## Table of Contents

- [Features](#features)
- [Tech Stack](#Tech-Stack)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Contributing](#contributing)

## Features

- Store GPS data for 2-wheeler vehicles.
- Calculate the distance traveled between two dates using GPS coordinates.
- Allow users to access GPS information for their vehicles.
- Support for multiple users owning multiple vehicles.
- RESTful API endpoints for managing vehicles, owners, and GPS data.


## Tech Stack

- **Java**: The core programming language used for developing the backend of the application.
- **Spring Boot**: A powerful and flexible framework for building Java-based applications. Used for creating RESTful APIs, managing database connections, and handling security.
- **Spring Data JPA**: Part of the Spring Data project, it simplifies data access using the Java Persistence API (JPA).
- **Database**: MySQL - Used for storing vehicle, owner, and GPS data.
- **Maven**: Build automation tools for managing project dependencies.

Feel free to explore the source code and project structure for more details on how these technologies are integrated into the project.


## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/Murli0399/Nunam-Assignment.git

## Usage
Access the application at http://localhost:8080.

Use the provided RESTful API endpoints (see API Endpoints).

## API Endpoints
- /vehicles: Manage vehicle information.
- /owners: Manage owner information.
- /gps-data: Manage GPS data.
- /api/calculate-distance: Calculate the distance traveled between two dates (GET request with startDate and endDate query parameters).


## Configuration
You can configure the application by editing 

   ```
   src/main/resources/application.properties.
   ```

Example application.properties:
```
#changing the server port
server.port=8088

#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root
```
## Contributing
Contributions are welcome! Please follow the Contribution Guidelines.
