# phonevalidator
Phone validator backend project for interview assignment

# Booting up the project
1. Go to the root directory and run mvnw clean package (it should generate a file named "phonevalidator.jar" inside ./target/)
2. **If you are running docker**, just build the image using command `docker build --tag=phonevalidator .` and run the docker container using `docker run -p8080:8080`.
 **If you are not running docker**, go to */target* directory on your CLI and run `java -jar phonevalidator.jar --spring.datasource.url=jdbc:sqlite:../src/main/resources/sample.db
`
3. You can get access to the swagger api at http://localhost:8080/swagger-ui.html
