#!/bin/sh

cd eureka
./mvnw clean package -DskipTests

cd ../email
./mvnw clean package -DskipTests

cd ../push
./mvnw clean package -DskipTests

cd ../sms
./mvnw clean package -DskipTests

cd ../gateway
./mvnw clean package -DskipTests

cd ..

docker-compose up --build