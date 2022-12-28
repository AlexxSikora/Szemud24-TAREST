package tests.Posts;
import finals.EndpointList;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import tests.baseTest;
import static io.restassured.RestAssured.given;
import static java.util.function.Predicate.not;
import static org.hamcrest.Matchers.*;
public class Posts extends baseTest {


    @Test
    public void getAllPosts(){
        given()
                .headers(header())
                .when()
                .get(EndpointList.POSTS)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void postCreation(){

        given().log().all()
                .headers("Content-Type", "application/json")
                .body(finals.Acrticles.Posts.REQUESTBODY)
                .when()
                .post(EndpointList.POSTS)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

    }

    @Test
    public void SpecificPost() {
        given()
                .headers(header())
                .pathParam("id", 1)
                .when()
                .get(EndpointList.DETAIL_POST)
                .then()
                .log()
                .ifError()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void deletePost(){
        given()
                .headers("Content-Type", "application/json")
                .pathParam("id", 1)
                .body(AUTH_BODY)
                .when()
                .post(URL + "/posts")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);


    }
}
