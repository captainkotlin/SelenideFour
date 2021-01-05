package reqres.users;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static org.hamcrest.Matchers.is;
import static web.util.json.JsonUtils.toJsonObject;

public class SingleUserNotFound extends AbstractUsersApiTest
{
    @Test
    public void singleUserNotFound()
    {
        given(requestSpecification)
                .log().all()
                .pathParam("id", 23)
                .accept(ContentType.JSON)
                .expect()
                .statusCode(HTTP_NOT_FOUND)
                .body("", is(toJsonObject("{}")))
                .when()
                .get("{id}");
    }
}
