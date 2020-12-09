package reqres.users;

import org.junit.jupiter.api.Test;
import utils.matchers.ParseableAsInteger;
import utils.matchers.ParseableAsZonedDateTime;

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
                .body("id", new ParseableAsInteger())
                .body("createdAt", new ParseableAsZonedDateTime())
                .when()
                .post();
    }
}
