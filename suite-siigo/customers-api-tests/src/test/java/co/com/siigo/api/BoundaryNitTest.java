package co.com.siigo.api;

import net.serenitybdd.junit5.SerenityTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SerenityTest
public class BoundaryNitTest {
    String base = System.getProperty("base.url", "http://localhost:8080/api/v1");

    @Test
    void nit_too_short_is_400() {
        String body = """
            { "type":"NATURAL", "identification":"1234", "email":"a@b.co",
              "firstName":"Ana", "lastName":"Lopez", "phone":"3001234567" }
        """;

        given().baseUri(base).basePath("/clients")
                .contentType("application/json").body(body)
        .when().post()
        .then().statusCode(400);
    }
}
