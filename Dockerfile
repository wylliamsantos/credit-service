FROM gradle:jdk16-hotspot AS build
ARG JAR_FILE=build/libs/credit-service-0.0.1-SNAPSHOT.jar
EXPOSE 8080
WORKDIR /app
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","-Xms512m", "-Djava.security.egd=file:/dev/./urandom", "-Dfile.encoding=UTF8", "-Duser.timezone=America/Sao_Paulo", "/app.jar"]