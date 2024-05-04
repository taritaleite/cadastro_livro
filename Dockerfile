FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/cadastro-0.0.1-SNAPSHOT.jar cadastro-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","cadastro-0.0.1-SNAPSHOT.jar"]