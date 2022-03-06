FROM maven:3.6.3-jdk-11 AS builder
RUN mkdir /project
WORKDIR /project
ADD pom.xml .
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]
COPY . /project
RUN mvn package -DskipTests


FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /app
COPY --from=builder /project/target/*.jar /app/
WORKDIR /app
ENTRYPOINT ["java", "-jar", "testCrud-0.0.1-SNAPSHOT.jar"]