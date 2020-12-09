package reqres.users;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import web.util.BodyMatcher;
import web.util.Responsify;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ListUsers extends AbstractUsersApiTest
{
    @Test
    public void listUsers()
    {
        var formatStr = "data[%d].%s";
        var emailStr = "email";
        var emailA = new BodyMatcher(equalTo("lindsay.ferguson@reqres.in"),  1, emailStr);
        var emailB = new BodyMatcher(equalTo("tobias.funke@reqres.in"), 2, emailStr);
        var dataSize = new BodyMatcher(is(6), "data.size()");

        var responseStr = Responsify.of(given(requestSpecification)
                .queryParam("page", 2)
                .accept(ContentType.JSON)
                .log().uri()
                .expect())
                .status(HTTP_OK)
                .bodyMatches(formatStr, emailA, emailB)
                .bodyMatch(dataSize)
                .when()
                .get()
                .andReturn()
                .asString();
    }
}
