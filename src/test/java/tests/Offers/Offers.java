package tests.Offers;

import finals.EndpointList;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import tests.baseTest;

import static finals.RequestsBody.Offers.EDITREQUESTBODY_;
import static finals.RequestsBody.Offers.REQUESTBODY_;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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

    public static Integer offerCreation =
            given().log().all()
                    .headers(header())
                    .body(finals.RequestsBody.Offers.REQUESTBODY)
                    .when()
                    .post(URL + "/offers")
                    .then()
                    .log()
                    .all()
                    .time(Matchers.lessThan(1000L))
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .body("data.attributes.title", equalTo(REQUESTBODY_.get("title")))
                    .body("data.attributes.description", equalTo(REQUESTBODY_.get("description")))
                    .body("data.attributes.price", equalTo(REQUESTBODY_.get("price")))
                    .body("data.attributes.phoneNumber", equalTo(REQUESTBODY_.get("phoneNumber")))
                    .body("data.attributes.negotiate", equalTo(REQUESTBODY_.get("negotiate")))
                    .body("data.attributes.username", equalTo(REQUESTBODY_.get("username")))
                    .extract()
                    .path("data.id");



    @Test
    public void specificOffer() {
        given()
                .headers(header())
                .pathParam("id", offerCreation)
                .when()
                .get(EndpointList.OFFERS_DETAIL)
                .then()
                .log()
                .ifError()
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.attributes.title", equalTo(REQUESTBODY_.get("title")))
                .body("data.attributes.description", equalTo(REQUESTBODY_.get("description")))
                .body("data.attributes.price", equalTo(REQUESTBODY_.get("price")))
                .body("data.attributes.phoneNumber", equalTo(REQUESTBODY_.get("phoneNumber")))
                .body("data.attributes.negotiate", equalTo(REQUESTBODY_.get("negotiate")))
                .body("data.attributes.username", equalTo(REQUESTBODY_.get("username")));
    }

    @Test
    public void editSpecificOffer() {
        given()
                .headers(header())
                .body(finals.RequestsBody.Offers.EDITREQUESTBODY)
                .pathParam("id", offerCreation)
                .when()
                .put(EndpointList.OFFERS_DETAIL)
                .then()
                .log()
                .ifError()
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.attributes.title", equalTo(EDITREQUESTBODY_.get("title")))
                .body("data.attributes.description", equalTo(EDITREQUESTBODY_.get("description")))
                .body("data.attributes.price", equalTo(EDITREQUESTBODY_.get("price")))
                .body("data.attributes.phoneNumber", equalTo(EDITREQUESTBODY_.get("phoneNumber")))
                .body("data.attributes.negotiate", equalTo(EDITREQUESTBODY_.get("negotiate")))
                .body("data.attributes.username", equalTo(EDITREQUESTBODY_.get("username")));
    }

    @Test
    public void deleteSpecificOffer() {
        editSpecificOffer();
        given().log().all()
                .headers(header())
                .pathParam("id", offerCreation)
                .when()
                .delete(EndpointList.OFFERS_DETAIL)
                .then()
                .log()
                .ifError()
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.attributes.title", equalTo(EDITREQUESTBODY_.get("title")))
                .body("data.attributes.description", equalTo(EDITREQUESTBODY_.get("description")))
                .body("data.attributes.price", equalTo(EDITREQUESTBODY_.get("price")))
                .body("data.attributes.phoneNumber", equalTo(EDITREQUESTBODY_.get("phoneNumber")))
                .body("data.attributes.negotiate", equalTo(EDITREQUESTBODY_.get("negotiate")))
                .body("data.attributes.username", equalTo(EDITREQUESTBODY_.get("username")))
                .body("data.id", equalTo(offerCreation));;

    }
}
