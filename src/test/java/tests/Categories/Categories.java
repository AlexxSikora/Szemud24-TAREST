package tests.Categories;

import finals.EndpointList;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import tests.baseTest;
import static io.restassured.RestAssured.given;
import static tests.baseTest.header;

public class Categories extends baseTest {
    @Test
    public void AllCategories() {
        given()
                .headers(header())
                .when()
                .get(EndpointList.CATEGORIES)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void SpecificCategory() {
        given()
                .headers(header())
                .pathParam("id", 1)
                .when()
                .get(EndpointList.CATEGORIES_DETAIL)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }
}
