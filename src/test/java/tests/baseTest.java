package tests;
import finals.AccountDetails.RegistrationAccountDetails;
import io.restassured.RestAssured;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.BeforeAll;
import java.io.Serializable;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class baseTest {

    public static String AUTH_BODY = RegistrationAccountDetails.correctLoginDetails;
    public static String URL = "http://localhost:1337/api";

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = URL;
    }

    public static String register =
            given()
                    .headers("Content-Type", "application/json")
                    .body(AUTH_BODY)
                    .when()
                    .post(URL + "/auth/local/register")
                    .then()
                    .extract()
                    .path("jwt");

    public static Map<String, Serializable> header() {
        return Map.of(
                HttpHeaders.AUTHORIZATION, "Bearer " + register,
                HttpHeaders.CONTENT_TYPE, "application/json");
    }
}



