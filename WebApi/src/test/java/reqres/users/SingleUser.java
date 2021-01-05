package reqres.users;

import org.junit.jupiter.api.Test;
import web.util.json.JsonValidatorUtils;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.is;
import static web.util.json.JsonUtils.toJsonObject;

public class SingleUser extends AbstractUsersApiTest
{
    @Test
    public void singleUser()
    {
        var body = given(requestSpecification)
                .log().all()
                .pathParam("id", 2)
                .expect()
                .statusCode(HTTP_OK)
                .body("size()", is(2))
                .body("data", is(toJsonObject("{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"}")))
                .when()
                .get("{id}")
                .then().log().all()
                .extract()
                .body().asString();
        var schemaPath = getPackageResourcePath("singleUser.json");
        JsonValidatorUtils.of(schemaPath).validateWithException(body);
    }
}
