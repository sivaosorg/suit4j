# Suit4J: A Suite of Spring Boot Projects

## Introduction

Welcome to `Suit4J`! This repository is a comprehensive collection of projects that demonstrate the versatility and
power of Spring Boot. Each project is a testament to the capabilities of Spring Boot in various scenarios.

## Overview

Spring Boot simplifies the process of creating stand-alone, production-grade Spring-based applications that "just run".
It provides an opinionated view of the Spring platform and third-party libraries, enabling you to get started with
minimal configuration.

This suite of projects showcases the application of Spring Boot in various contexts, including:

- **Web Development**
- **Data Access**
- **Authentication and Authorization**
- **Testing**
- **Deployment**

## Features

- Written in **Java 1.8** or higher.
- **Well-documented** code for easy understanding.
- Regular updates and maintenance for **continuous improvement**.

## Installation

```bash
git clone --depth 1 https://github.com/sivaosorg/suit4j.git
```

## Usage

This section explains how users can interact with the various modules. Each module can be managed using the following
commands:

- **run**: Run the Spring Boot application using Gradle's `bootRun` task.
- **build**: Build the JAR file using Gradle's `bootJar` task.
- **clean**: Clean build artifacts using Gradle's `clean` task.
- **rebuild**: Clean, build the JAR file, and run the Spring Boot application.
- **task**: List available Gradle tasks.
- **test**: Run tests using Gradle's `test` task.
- **unlink**: Remove all log files from the `logs` directory.
- **rollout**: Clean, build the JAR file, and run it with the specified Spring profile (default is `local`).
- **execute**: Make the `run.sh` script executable and run it with the specified Spring profile.

## Command

Here are the commands to interact with the application:

```shell
# Run the application
make run

# Build the JAR file
make build

# Clean build artifacts
make clean

# Rebuild the project and run it
make rebuild

# List available tasks
make task

# Run tests
make test

# Remove all log files
make unlink

# Clean, build, and run the application with the default profile (`local`)
make rollout

# Clean, build, and run the application with a specified profile (e.g., `production`)
make rollout profile=prod

# Make the `run.sh` script executable and run it with the default profile (`local`)
make execute

# Make the `run.sh` script executable and run it with a specified profile (e.g., `production`)
make execute profile=prod
```

## Configuration

| # | Configs                  | Description                                                                                  |
|---|--------------------------|----------------------------------------------------------------------------------------------|
| 1 | `gradle.yml`             | Defines the Gradle build configuration and JAR output with a specific version                |
| 2 | `application.yml`        | Defines Spring profiles and common configuration                                             |            
| 3 | `application-common.yml` | Defines Spring Servlet information: **port**, **encoding**, **timezone**, **date-format**... |
| 4 | `application-log.yml`    | Defines logging configuration: **format**, **level**, **filename**                           |
| 5 | `application-dev.yml`    | Defines environment-specific properties for **development** and **staging**                  |
| 6 | `application-prod.yml`   | Defines environment-specific properties for **production**                                   |
| 7 | `application-local.yml`  | Defines environment-specific properties for **local development**                            |
| 8 | `logback.xml`            | Defines Logback logging configuration: **logger format**, **pattern**                        |
