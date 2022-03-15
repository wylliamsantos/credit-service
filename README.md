# credit-service

[![codecov](https://codecov.io/gh/wylliamsantos/credit-service/branch/main/graph/badge.svg?token=4265S6LK23)](https://codecov.io/gh/wylliamsantos/credit-service) ![Known Vulnerabilities](https://snyk.io/test/github/wylliamsantos/credit-service/badge.svg)

This project was created to show development skills with Springboot and Java 16.

## Frameworks and Tecnologies

All the project's dependencies are listed below:

- Java 16
- Spring Boot 2
- DMN Camunda
- Hibernate Validator
- Lombok

## Installation

Project requires [Java 16](https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html) to run.

Install the dependencies and devDependencies and start the server.

```sh
./gradlew clean bootJar
```

## Docker

```sh
docker run --name credit-service -p 8200:8080 -d wylliamsantos/credit-service
```

> Note 1: Image is pushed automatically to DockerHub when you commit code using Github Actions.

```sh
127.0.0.1:8200
```