# tp15

# Banque Service - GraphQL Spring Boot Application

This is a Spring Boot application demonstrating GraphQL integration for managing bank accounts.

## Features

- GraphQL API for bank account management
- H2 in-memory database
- Support for COURANT and EPARGNE account types
- Query and mutation operations
- GraphiQL interface enabled

## Technologies Used

- Java 21
- Spring Boot 3.5.7
- Spring Data JPA
- Spring GraphQL
- H2 Database
- Lombok
- Maven

## Running the Application

```bash
./mvnw spring-boot:run
```

The application will start on port 8082.

## GraphQL Endpoints

- GraphiQL UI: http://localhost:8082/graphiql
- H2 Console: http://localhost:8082/h2-console

## Example Queries

### Get all accounts
```graphql
query {
  allComptes {
    id
    solde
    dateCreation
    type
  }
}
```

### Get account by ID
```graphql
query {
  compteById(id: 1) {
    id
    solde
    dateCreation
    type
  }
}
```

### Get total statistics
```graphql
query {
  totalSolde {
    count
    sum
    average
  }
}
```

### Create new account
```graphql
mutation {
  saveCompte(compte: {
    solde: 15000.0
    type: EPARGNE
  }) {
    id
    solde
    type
  }
}
```

