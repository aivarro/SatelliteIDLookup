package eu.spaceit.satelliteidlookup.satellite;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class SatelliteResourceTest {

    @Test
    void create() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"internationalDesignator\":\"xyz\",\"name\":\"testTube\",\"yearOfLaunch\":2020,\"orbitType\":\"GEO\"}")
                .when().post("/satellite")
                .then()
                .statusCode(204);
    }

    @Test
    void getSatellite() {
        create();
        given()
                .pathParam("id", "xyz")
                .when().get("/satellite/{id}")
                .then()
                .statusCode(200)
                .body(is("{\"internationalDesignator\":\"xyz\",\"name\":\"testTube\",\"yearOfLaunch\":2020,\"orbitType\":\"GEO\"}"));
    }

    @Test
    void update() {
        create();
        given()
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"internationalDesignator\" : \"xyz\"," +
                        "\"name\" : \"73577ub3\"," +
                        "\"yearOfLaunch\" : 2020," +
                        "\"orbitType\" : \"GEO\"" +
                        "}")
                .when().put("/satellite")
                .then()
                .statusCode(204);
    }

    @Test
    void delete() {
        create();
        given()
                .pathParam("id", "xyz")
                .when().delete("/satellite/{id}")
                .then()
                .statusCode(204);
    }
}