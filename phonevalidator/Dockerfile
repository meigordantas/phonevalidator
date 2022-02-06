FROM openjdk:11
COPY target/phonevalidator.jar phonevalidator.jar
COPY src/main/resources/sample.db sample.db
ENTRYPOINT ["java","-jar","/phonevalidator.jar", "--spring.datasource.url=jdbc:sqlite:/sample.db"]