package tests.Users;
import finals.EndpointList;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import tests.baseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static tests.baseTest.header;

public class Users extends baseTest {

    @Test
    public void GetAllUsers(){
        given()
                .headers(header())
                .when()
                .get(EndpointList.USERS)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    }

    @Test
    public void GetMyUser(){
        given()
                .headers(header())
                .when()
                .get(EndpointList.USERME)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$", not(hasValue(nullValue())));
    }
}
