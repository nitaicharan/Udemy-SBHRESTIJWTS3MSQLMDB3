FROM maven:3-openjdk-15-slim AS build

WORKDIR /tmp/udemy_sbhrestijwts3msqlmdb3/

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:15-jdk-alpine

EXPOSE 8080

WORKDIR /opt/udemy_sbhrestijwts3msqlmdb3/

COPY --from=build /tmp/udemy_sbhrestijwts3msqlmdb3/target/cursomc-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "/opt/udemy_sbhrestijwts3msqlmdb3/cursomc-0.0.1-SNAPSHOT.jar"]
