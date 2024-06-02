# Define the directory where the JAR file is located after build
BUILD_DIR=build/libs
# Default profile if not specified
profile?=local
# Declare targets as phony to avoid conflicts with files of the same name
.PHONY: run build clean rebuild task test unlink rollout

# Run the Spring Boot application using Gradle's bootRun task
run:
	./gradlew bootRun
# Build the JAR file using Gradle's bootJar task
build:
	./gradlew bootJar
# Clean build artifacts using Gradle's clean task
clean:
	./gradlew clean
# Rebuild the project and run it
rebuild: clean build run
# List available Gradle tasks
task:
	./gradlew tasks
# Run tests using Gradle's test task
test:
	./gradlew test
# Remove all log files from the logs directory
unlink:
	rm -rf logs/*
# Clean, build the JAR file, and run it with the 'local' Spring profile
rollout: clean build
	java -jar $(shell ls $(BUILD_DIR)/*.jar | head -n 1) --spring.profiles.active=$(profile)
execute:
	chmod +x run.sh
	./run.sh $(profile)
