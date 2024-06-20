
# Pet-Friendly Boat Rental Service API

## Overview

The development of this project was made using Spring Boot and implementing a hexagonal architecture to take advantage of its benefits like high testability, scalability, and maintainability among others.

## Technologies

- Java 17
- Spring Boot 3.3.0
- GraphQL
    - GraphiQL
- FlywayDB (Database migration tool)
- PostgreSQL 13
- Docker using docker-compose for containerized deployment

## Installation

### Prerequisites

Install the latest version of Docker Desktop or another Docker distribution like Rancher Desktop.

### Deployment

1. Clone the repository to your local machine.

2. Navigate to the root of the project (`/petservice`).

3. Execute the following command using a command line interface (CLI) to build and start the containers:

   ```bash
   docker-compose up --build -d
   ```

    The complete deployment is expected to take less than 5 minutes on average.


4.  Optionally, to monitor the startup of the containers, you can view the logs:

    See the Postgres container logs:
   ```bash
   docker-compose logs -f postgres
   ```

See the app container logs for the Spring Boot application:

   ```bash
   docker-compose logs -f app
   ```

5. Access the application at http://localhost:8081 once all services are up and running.

### Access to GraphiQL
http://localhost:8081/graphiql?path=/graphql

```graphql
query {
  eligiblePets {
    id
    owner {
      ownerId
      ownerName
    }
    weight
    breed
    vaccinationStatus
    trainingLevel
  }
}
```

## GraphQL Mutation Example

```graphql
mutation {
  createPet(
    addPetCommand: { 
      owner: { ownerId: "12345", ownerName: "ownerName1" }, 
      weight: 25, 
      breed: "Labrador", 
      vaccinationStatus: true, 
      trainingLevel: 3	
    }
  ) {
    id
    owner {
      ownerId
      ownerName
    }
    weight
    breed
    vaccinationStatus
    trainingLevel
  }
}
```

6. Access to the database

URL
```bash
jdbc:postgresql://localhost:5433/petdb
```

User
```bash
user1
```

Password
```bash
pass1
```