FROM maven:3.6-jdk-11

WORKDIR /microservice-email-sender

COPY target/email-0.0.1-SNAPSHOT.jar /microservice-email-sender/target/email-0.0.1-SNAPSHOT.jar

RUN ["ls", "/microservice-email-sender"]

EXPOSE 8080

ENTRYPOINT [ "java", "-Xmx2048m", "-jar","/microservice-email-sender/target/email-0.0.1-SNAPSHOT.jar" ]