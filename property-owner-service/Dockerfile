FROM openjdk:11
ADD ./target/property-owner-service-0.0.1-SNAPSHOT.jar /usr/src/property-owner-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java", "-jar", "property-owner-service-0.0.1-SNAPSHOT.jar"]