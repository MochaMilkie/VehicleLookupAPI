# Vehicle Catalog API

A REST API for looking up vehicle details by VIN, built with Spring Boot.

## Features
- Look up a vehicle by VIN
- VIN format validation (length, invalid characters, check digit)
- Clear JSON error responses (400 for invalid VINs, 404 when not found)

## Tech stack
- Java 21
- Spring Boot
- Maven
- JUnit 5 and MockMvc

## Getting started

### Requirements
- JDK 21 or newer
- Maven (or use the included `./mvnw` wrapper)

### Run the app
```bash
./mvnw spring-boot:run
```
The API starts at `http://localhost:8080`.

### Run the tests
```bash
./mvnw test
```

## API endpoints

| Method | Path             | Description                  | Success | Errors   |
|--------|------------------|------------------------------|---------|----------|
| GET    | `/vehicles/{vin}`| Get a vehicle by its VIN     | 200     | 400, 404 |

### Example
```bash
curl http://localhost:8080/vehicles/1HGCM82633A004352
```
```json
{
  "vin": "1HGCM82633A004352",
  "make": "Honda",
  "model": "Accord",
  "year": 2003
}
```

## Project structure
```
controller/   HTTP endpoints
service/      business logic
model/        data classes
exception/    error handling
```

## Roadmap
- [ ] Decode VINs using the NHTSA vPIC API
- [ ] Store results in a database (Spring Data JPA)
- [ ] OpenAPI/Swagger documentation
- [ ] Dockerfile and CI build
