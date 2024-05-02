package tests.testng.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ChuckNorris {
    private static final Logger LOGGER = LogManager.getLogger(ChuckNorris.class);

    RequestSpecification requestSpecRandom = new RequestSpecBuilder()
            .setBaseUri("https://api.chucknorris.io/jokes/random")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Test
    public void retrieveRandomJoke() {
        String randomJoke = RestAssured.given()
                .spec(requestSpecRandom)
                .when()
                .get()
                .then()
                .extract().body().asString();
        LOGGER.info(randomJoke);
    }

    @Test
    public void retrieveRandomJokeValue() {
        String randomJokeValue = RestAssured.given()
                .spec(requestSpecRandom)
                .when()
                .get().path("value");
        LOGGER.info(randomJokeValue);
    }

}
