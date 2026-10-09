# VehicleLookupAPI

A small REST API built with Spring Boot that decodes a Vehicle Identification Number (VIN) into the vehicle's year, make and model. It uses the free [NHTSA vPIC API](https://vpic.nhtsa.dot.gov/api/) as its data source.

I built this project to learn Spring Boot and REST API design in Java.

## Features

- Decode a 17-character VIN into year, make and model
- VIN validation (correct length, allowed characters only; the letters I, O and Q are never valid in a VIN)
- Consistent JSON error responses with an error code and a message
- Unit tests for VIN validation and vehicle building

## Tech stack

- Java 25
- Spring Boot 4.1.1 (Spring Web MVC, `RestClient`)
- Maven (wrapper included, no Maven install needed)
- JUnit 5

## Getting started

### Requirements

- JDK 25
- An internet connection (the app calls the NHTSA API)

### Run the app

On macOS or Linux:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The API starts on `http://localhost:8080`.

### Run the tests

```bash
./mvnw test
```

## API

### Decode a VIN

```
GET /vin-decoder?vin={VIN}
```

| Parameter | Description |
|-----------|-------------|
| `vin` | A 17-character VIN (required) |

**Example request**

```bash
curl "http://localhost:8080/vin-decoder?vin=1FTRW12W06KD29937"
```

**Example response**

```json
{
  "VIN": { "vin": "1FTRW12W06KD29937" },
  "year": 2006,
  "make": "FORD",
  "model": "F150"
}
```

### Errors

Errors are returned as JSON with an error code and a message:

```json
{
  "error": "INVALID_VIN",
  "message": "ABC123 is not a valid VIN"
}
```

| Error code | HTTP status | When it happens |
|------------|-------------|-----------------|
| `INVALID_VIN` | 400 | The VIN is not 17 characters or contains invalid characters |
| `INVALID_NHTSA_RESPONSE` | 500 | The NHTSA API returned an unusable response or could not be reached |

## Project structure

```
src/main/java/me/mochamilkie/vehiclelookupapi/
├── VehicleController.java     # HTTP endpoint
├── Exceptions/                # Custom exceptions, error codes, global error handler
├── VehicleData/               # Vehicle, VIN, service and builder classes
└── VinDecoder/                # Client and response types for the NHTSA API
```

The request flows controller, then service, then NHTSA client. The service turns the NHTSA result into a `Vehicle`, and a global exception handler turns exceptions into JSON error responses. Classes are wired together with Spring's constructor injection.

## What I learned

- Structuring a Spring Boot app into controller, service and client layers
- Dependency injection with `@Service`, `@Component` and constructor injection
- Calling an external REST API with `RestClient`
- Using Java records for immutable data and validation in a compact constructor
- Centralized error handling with `@RestControllerAdvice`
- Writing unit tests with JUnit 5

## Data source

Vehicle data comes from the [NHTSA vPIC API](https://vpic.nhtsa.dot.gov/api/), a free public service of the U.S. National Highway Traffic Safety Administration. This project is not affiliated with NHTSA.