package co.com.siigo.api;

import net.serenitybdd.junit5.SerenityTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SerenityTest
public class CreateClientTest {

    String base = System.getProperty("base.url", "http://localhost:8080/api/v1");

    @Test
    void create_natural_ok() {
        String body = """
                { "type":"NATURAL", "identification":"12345678", "email":"a@b.co",
                  "firstName":"Ana", "lastName":"Lopez", "phone":"3001234567" }
                """;

        given().baseUri(base).basePath("/clients")
                .contentType("application/json")
                .body(body)
        .when().post()
        .then().statusCode(anyOf(is(200), is(201)))
                .body("type", equalTo("NATURAL"))
                .body("status", equalTo("ACTIVE"))
                .body("id", notNullValue());
    }
}
