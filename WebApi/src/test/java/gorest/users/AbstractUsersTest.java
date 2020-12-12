package gorest.users;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import web.util.AbstractApiTest;

public class AbstractUsersTest extends AbstractApiTest
{
    protected static RequestSpecification requestSpecification;

    @BeforeAll
    public static void beforeAll()
    {
        AbstractApiTest.doParentBeforeSuite();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/public-api/users")
                .build();
    }

}
