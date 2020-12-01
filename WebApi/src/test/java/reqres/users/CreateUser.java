package reqres.users;

import org.junit.jupiter.api.Test;
import web.utils.matchers.IsInteger;
import web.utils.matchers.IsZonedDateTime;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_CREATED;

public class CreateUser extends AbstractUsersApiTest
{
    @Test
    public void createUser()
    {
        given(requestSpecification)
                .log().all()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .expect()
                .log().all()
                .statusCode(HTTP_CREATED)
                .body("id", new IsInteger())
                .body("createdAt", new IsZonedDateTime())
                .when()
                .post();
    }
}
