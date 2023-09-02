# Nunam-Assignment
# Vehicle GPS Tracking System

A Spring Boot application that allows users to track GPS data for their vehicles and calculate the distance traveled between two dates based on the stored GPS coordinates.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
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

## Prerequisites

- Java 11 or higher
- Maven or Gradle
- Database (e.g., H2, MySQL, PostgreSQL)

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
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/vehicle_gps_db
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Other Configuration
# ...
```
## Contributing
Contributions are welcome! Please follow the Contribution Guidelines.
