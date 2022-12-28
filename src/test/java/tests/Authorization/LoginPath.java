package tests.Authorization;
import finals.AccountDetails.LoginAccountDetails;
import finals.EndpointList;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import tests.baseTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.nullValue;

    public class LoginPath extends baseTest {


        @Test
        public void correctSignIn(){
            given()
                    .headers(header())
                    .body(LoginAccountDetails.correctCredentials)
                    .when()
                    .post(EndpointList.SIGN_IN)
                    .then()
                    .log()
                    .ifError()
                    .time(Matchers.lessThan(1000L))
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .contentType(ContentType.JSON)
                    .log()
                    .ifError();
        }

        @Test
        public void signInEmptyEmailTest(){
            given()
                    .headers(header())
                    .body(LoginAccountDetails.EmptyEmailAcc)
                    .when()
                    .post(EndpointList.SIGN_IN)
                    .then()
                    .log()
                    .ifError()
                    .time(Matchers.lessThan(1000L))
                    .assertThat()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .contentType(ContentType.JSON)
                    .log()
                    .ifError();
        }

        @Test
        public void signInEmptyPasswordTest() {
            given()
                    .headers(header())
                    .body(LoginAccountDetails.EmptyPasswordAcc)
                    .when()
                    .post(EndpointList.SIGN_IN)
                    .then()
                    .log()
                    .ifError()
                    .assertThat()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .contentType(ContentType.JSON)
                    .log()
                    .ifError();
        }

        @Test
        public void signInEmptyEmailAndPasswordTest() {
            given()
                    .headers(header())
                    .body(LoginAccountDetails.allBlankFieldsAcc)
                    .when()
                    .post(EndpointList.SIGN_IN)
                    .then()
                    .log()
                    .ifError()
                    .assertThat()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .contentType(ContentType.JSON)
                    .body("$", hasValue(nullValue()))
                    .log()
                    .ifError();
        }


    }