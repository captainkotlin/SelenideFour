package reqres.unknown;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import web.utils.AbstractTest;

public class AbstractResourceApiTest extends AbstractTest
{
    protected static RequestSpecification requestSpec;


    @BeforeAll
    public static void doParentBeforeSuite()
    {
        AbstractTest.doParentBeforeSuite();
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api/unknown")
                .build();
    }
}
