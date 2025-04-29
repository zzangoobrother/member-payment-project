FROM openjdk:17-ea-11-jdk-slim

COPY build/libs/member-payment-project-0.0.1-SNAPSHOT.jar app.jar
ENV TZ=Asia/Seoul
ENTRYPOINT ["java","-Dspring.profiles.active=${USE_PROFILE}", "-jar", "app.jar"]
