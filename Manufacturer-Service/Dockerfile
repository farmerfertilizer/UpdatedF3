FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} manufacturer-service.jar
ENTRYPOINT ["java","-jar","/manufacturer-service.jar"]
EXPOSE 5014