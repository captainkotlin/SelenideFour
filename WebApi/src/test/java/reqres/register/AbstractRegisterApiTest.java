package reqres.register;

import io.restassured.builder.RequestSpecBuilder;
import org.junit.jupiter.api.BeforeAll;
import web.util.AbstractApiTest;

public class AbstractRegisterApiTest extends AbstractApiTest
{
    @BeforeAll
    public static void doParentBeforeSuite()
    {
        AbstractApiTest.doParentBeforeSuite();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api/register")
                .build();
    }
}
