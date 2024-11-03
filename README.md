# Finance Preferences Backend Application
This Spring Boot back-end application allows users to manage their financial preferences and retrieve mock financial data. Built with modularity and scalability in mind, this application is a foundation for future integrations with live finance APIs.

# Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Getting Started](#getting-started)
5. [Endpoints and Usage](#endpoints-and-usage)
6. [Database Configuration](#database-configuration)
7. [Future Improvements](#future-improvements)

## Introduction

This Finance Backend Application is a Spring Boot-based API that provides basic CRUD operations for user preferences related to finance, along with mock financial data endpoints for stock prices and currency exchange rates.

The application supports creating, reading, updating, and deleting user preferences stored in a MySQL database. It also includes endpoints to fetch mock financial data, like stock prices and exchange rates, for a more dynamic user experience.

## Features

* **User Preferences**: Create, read, update, and delete user financial preferences.
* **Mock Financial Data**: Retrieve mock stock prices and exchange rates for demonstration.
* **RESTful API Design**: Exposes RESTful endpoints accessible with tools like Postman.

## Technologies Used

* **Java**: Main programming language
* **Spring Boot**: Framework for building the application
* **Spring Data JPA and Hibernate**: Object-relational mapping (ORM) for database interaction
* **MySQL**: Database for storing user preferences
* **Lombok**: Java library to reduce boilerplate code
* **Postman**: For testing API endpoints

## Getting Started
 
1. **Clone the Repository**:

In any command prompt or on your console:
```git clone https://github.com/benhuh111/finance_backend.git``` 

```cd DEVjensen```

2. **Prerequisites**:
    
* Java 17+
* MySQL database setup
* IDE

3. **Setup MySQL Database**: Create a database in MySQL:
    
```CREATE DATABASE finance_backend;```
    
4. **Configure application.yml**: In the src/main/resources/application.yml file, configure your database details:
```
spring:
  datasource:
  url: jdbc:mysql://localhost:3306/finance_backend
    username: root
    password: your_password_here
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  logging:
    level:
      org:
        springframework:
          web: DEBUG
```
5. **Run the Application**:

* Open your project in your IDE.
* Build and run the application.
* The application should start on ```HTTP://localhost:8080```.

## Endpoints and Usage

These endpoints can be accessed via Postman or through direct HTTP requests.

### User Preferences Endpoints

| Method | Endpoint | Description |
|----------|----------|----------|
| GET    | /api/preferences   | Get all user preferences   |
| GET    | /api/preferences/{id}   | Get a specific user preference by ID   |
| POST    | /api/preferences   | Create a new user preference   |
| PUT    | /api/preferences/{id}   | Update a specific user preference   |
| DELETE    | /api/preferences/{id}   | Delete a specific user preference   |

### Mock Financial Data Endpoints

| Method | Endpoint | Description |
|----------|----------|----------|
| GET    | /api/preferences/{ticker}   | Get mock stock price for a specific ticker   |
| GET    | /api/preferences/{currencyPair}   | Get mocke xchange rate for a currency pair   |

## Database Configuration

This application uses MySQL to persist user preferences. Ensure your MySQL server is running, and that the application.yml configuration matches your MySQL setup.

## Future Improvements
* **API Integration**: Integrate with a real finance API to replace mock data.
* **User Authentication**: Add user authentication and authorization to secure endpoints.
* **Data Validation**: Implement validation for inputs in the UserPreference model to prevent invalid data.

