FROM openjdk:11
COPY target/phonevalidator.jar phonevalidator.jar
COPY src/main/resources/sample.db sample.db
ENTRYPOINT ["java","-jar","/phonevalidator.jar", "--${DB_PATH}=/sample.db", "-Dserver.port=8080"]