package tests.Posts;
import finals.EndpointList;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import tests.baseTest;
import static io.restassured.RestAssured.given;
import static java.lang.Integer.parseInt;
import static org.hamcrest.Matchers.*;

public class Posts extends baseTest {

    @Test
    public void getAllPosts() {
        given()
                .headers(header())
                .when()
                .get(EndpointList.POSTS)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$", not(hasValue(nullValue())));
    }


    public static Integer postCreation =
            given().log().all()
                    .headers(header())
                    .body(finals.RequestsBody.Posts.REQUESTBODY)
                    .when()
                    .post(URL + "/posts")
                    .then()
                    .log()
                    .all()
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                    .extract()
                    .path("data.id");


    @Test
    public void specificPost() {
        given().log().all()
                .headers(header())
                .pathParam("id", postCreation)
                .when()
                .get(EndpointList.DETAIL_POST)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(postCreation));
    }


    @Test
    public void deletePost() {
        given()
                .headers(header())
                .pathParam("id", postCreation)
                .body(AUTH_BODY)
                .when()
                .delete(EndpointList.DETAIL_POST)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(postCreation));
    }


}