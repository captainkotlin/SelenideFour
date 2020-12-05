package reqres.unknown;

import org.junit.jupiter.api.Test;
import reqres.unknown.entities.Resource;

import static io.restassured.RestAssured.given;

public class SingleResource extends AbstractResourceApiTest
{
    @Test
    public void singleResource()
    {
        var resource = given(requestSpec)
                .log().all(false)
                .pathParam("id", 2)
                .expect()
                .when()
                .get("{id}")
                .then()
                .extract()
                .body()
                .as(Resource.class);
    }
}
