package reqres.register;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import web.utils.matchers.IsInteger;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.hasKey;

public class RegisterSuccessful extends AbstractRegisterApiTest
{
    @Test
    public void registerSuccessful()
    {
        given(requestSpecification)
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
                .expect()
                .log().all()
                .body("id", new IsInteger())
                .body("", hasKey("token"))
                .statusCode(HTTP_OK)
                .when()
                .post();
    }
}
