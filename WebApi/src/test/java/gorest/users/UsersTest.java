package gorest.users;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasXPath;

public class UsersTest extends AbstractUsersTest
{
    @ParameterizedTest
    @CsvFileSource(resources = "usersTest.csv", numLinesToSkip = 1)
    public void usersTest(int userId, String xpathA, String xpathB)
    {
        given(requestSpecification)
                .log().all()
                .pathParam("userId", userId)
                .expect()
                .log().all()
                .body(hasXPath(xpathA), hasXPath(xpathB))
                .when()
                .get("{userId}/posts.xml");
    }
}
