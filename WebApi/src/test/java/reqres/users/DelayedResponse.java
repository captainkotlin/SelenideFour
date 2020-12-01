package reqres.users;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class DelayedResponse extends AbstractUsersApiTest
{
    @Test
    public void delayedResponse()
    {
        var queryMs = 4000L;
        var realTimeMs = queryMs + 2000;
        var responseSpec = expect().time(lessThan(realTimeMs));
        given(requestSpecification)
                .log().all()
                .queryParam("delay", queryMs)
                .expect()
                .response().spec(responseSpec)
                .when()
                .get();
    }
}
