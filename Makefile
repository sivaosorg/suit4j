# Define the directory where the JAR file is located after build
BUILD_DIR=build/libs
LOG_DIR=logs
# Default profile if not specified
profile?=local
# Declare targets as phony to avoid conflicts with files of the same name
.PHONY: run build clean rebuild task test unlink rollout

# Run the Spring Boot application using Gradle's bootRun task
run:
	clear
	./gradlew bootRun --args='--spring.profiles.active=$(profile)'
# Build the JAR file using Gradle's bootJar task
build:
	clear
	rm -rf build/*
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
tree:
	# Create logs directory if not exists
	mkdir -p $(LOG_DIR)
	# Generate project structure and save it to logs/project_structure.txt
	tree -I ".gradle|.idea|build|logs" > ./$(LOG_DIR)/project_structure.txt
