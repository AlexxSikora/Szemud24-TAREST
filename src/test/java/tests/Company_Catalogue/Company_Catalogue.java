package tests.Company_Catalogue;

import finals.EndpointList;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import tests.baseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static tests.baseTest.header;

public class Company_Catalogue extends baseTest {
    @Test
    public void AllCatalogues() {
        given()
                .headers(header())
                .when()
                .get(EndpointList.COMPANY_CATALOGUE)
                .then()
                .log()
                .all()
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    public static Integer catalogueCreation =
            given().log().all()
                    .headers(header())
                    .body(finals.RequestsBody.Catalogues.REQUESTBODY)
                    .when()
                    .post(URL + "/company-catalogues")
                    .then()
                    .log()
                    .all()
                    .time(Matchers.lessThan(1000L))
                    .assertThat()
                    .time(Matchers.lessThan(1000L))
                    .statusCode(HttpStatus.SC_OK)
                    .extract()
                    .path("data.id");


    @Test
    public void specificCompanyCatalogue() {
        given().log().all()
                .headers(header())
                .pathParam("id", catalogueCreation)
                .when()
                .get(EndpointList.COMPANY_CATALOGUE_DETAIL)
                .then()
                .log()
                .all()
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(catalogueCreation));
    }

    @Test
    public void editCompanyCatalogue() {
        given().log().all()
                .headers(header())
                .body(finals.RequestsBody.Catalogues.EDITREQUESTBODY)
                .pathParam("id", catalogueCreation)
                .when()
                .put(EndpointList.COMPANY_CATALOGUE_DETAIL)
                .then()
                .log()
                .all()
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", not(equalTo("123123123")));
    }

    @Test
    public void deleteCompanyCatalogue() {
        given().log().all()
                .headers(header())
                .pathParam("id", catalogueCreation)
                .when()
                .delete(EndpointList.COMPANY_CATALOGUE_DETAIL)
                .then()
                .log()
                .all()
                .time(Matchers.lessThan(1000L))
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(catalogueCreation));
    }
}
