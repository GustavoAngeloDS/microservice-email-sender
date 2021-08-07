# Microservice-email-sender

## What does this application?
Basically this project send emails. You can fill the json request using this schema example: 
{
    "ownerRef": "string",
    "emailFrom": "string",
    "emailTo": "string",
    "subject": "string",
    "text": "string"
}

## This application use the following technologies and frameworks:
- Java
- Spring Data JPA
- Spring Starter Mail
- Spring Validation
- Lombok
- H2DataBase
- Maven
- RabbitMQ

## Usage 
To use this project you need to configure the application.properties file with the information of a SMTP to send email 
and a RabbitMQ host (you can create one free at https://cloudamqp.com/) 

## Data Storage
Well, the principal objective of this project is know some new technologies focused in java stack, that's why I used H2 database.
The H2 is a local memory database. If you restart the application for some reason, all data is lost. 
You can easily change the database. Just put another dependency at the pom.xml and configure the database at the application.properties file.
