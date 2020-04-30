FROM openjdk:14

WORKDIR /app

ADD wait-for.sh .
ADD target/sms.jar .

RUN chmod +x wait-for.sh

EXPOSE 8080