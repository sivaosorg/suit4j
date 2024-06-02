#!/bin/bash

# Define the directory where the JAR file is located after build
BUILD_DIR=build/libs
# Default profile if not specified
PROFILE=${1:-local}
# Function to clean, build the JAR file, and run it with the specified Spring profile
rollout() {
  # Clean build artifacts
  ./gradlew clean
  # Build the JAR file
  ./gradlew bootJar
  # Find the first JAR file in the build/libs directory and run it with the specified Spring profile
  java -jar $(ls ${BUILD_DIR}/*.jar | head -n 1) --spring.profiles.active=${PROFILE}
}
# Run the rollout function
rollout

# Usages:
# 1. Make the script executable:
# chmod +x run.sh
# 2. Run the script with a specific profile:
# ./run.sh production
# Run the script with the default profile (local):
# ./run.sh
