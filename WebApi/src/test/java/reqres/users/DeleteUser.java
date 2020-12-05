package reqres.users;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_NO_CONTENT;

public class DeleteUser extends AbstractUsersApiTest
{
    @Test
    public void deleteUser()
    {
        given(requestSpecification)
                .log().all()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .expect()
                .log().all()
                .statusCode(HTTP_NO_CONTENT)
                .when()
                .delete();
    }
}
