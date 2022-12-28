package tests.Categories;

import finals.EndpointList;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import tests.baseTest;

import static finals.RequestsBody.Categories.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
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
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    public static Integer categoryCreation =
            given().log().all()
                    .headers(header())
                    .body(REQUESTBODY)
                    .when()
                    .post(URL + "/categories")
                    .then()
                    .log()
                    .all()
                    .time(Matchers.lessThan(1000L))
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .body("data.attributes.name", equalTo(REQUESTBODY_.get("name")))
                    .extract()
                    .path("data.id");

    @Test
    public void SpecificCategory() {
        given().log().all()
                .headers(header())
                .pathParam("id", categoryCreation)
                .when()
                .get(EndpointList.CATEGORIES_DETAIL)
                .then()
                .log()
                .ifError()
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(categoryCreation));;

    }

    @Test
    public void editSpecificCategory() {
        given().log().all()
                .headers(header())
                .body(finals.RequestsBody.Categories.EDITREQUESTBODY)
                .pathParam("id", categoryCreation)
                .when()
                .put(EndpointList.CATEGORIES_DETAIL)
                .then()
                .log()
                .ifError()
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.attributes.name", equalTo(EDITREQUESTBODY_.get("name")))
                .body("data.id", equalTo(categoryCreation));;

    }

    @Test
    public void deleteSpecificCategory() {
        editSpecificCategory();
        given().log().all()
                .headers(header())
                .pathParam("id", categoryCreation)
                .when()
                .delete(EndpointList.CATEGORIES_DETAIL)
                .then()
                .log()
                .ifError()
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.attributes.name", equalTo(EDITREQUESTBODY_.get("name")))
                .body("data.id", equalTo(categoryCreation));;

    }
}
