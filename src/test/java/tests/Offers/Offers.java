package tests.Offers;

import finals.EndpointList;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import tests.baseTest;

import static io.restassured.RestAssured.given;
import static tests.baseTest.header;

public class Offers extends baseTest {
    @Test
    public void AllCategories() {
        given()
                .headers(header())
                .when()
                .get(EndpointList.OFFERS)
                .then()
                .log()
                .ifError()
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void SpecificCategory() {
        given()
                .headers(header())
                .pathParam("id", 1)
                .when()
                .get(EndpointList.OFFERS_DETAIL)
                .then()
                .log()
                .ifError()
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }
}
