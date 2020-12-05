package reqres.users;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.hasKey;

public class PatchUser extends AbstractUsersApiTest
{
    @Test
    public void updateUser()
    {
        given(requestSpecification)
                .log().all()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .expect()
                .log().all()
                .statusCode(HTTP_OK)
                .body("", hasKey("updatedAt"))
                .when()
                .patch();
    }
}
