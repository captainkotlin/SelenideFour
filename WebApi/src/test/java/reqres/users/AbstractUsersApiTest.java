package reqres.users;

import io.restassured.builder.RequestSpecBuilder;
import org.junit.jupiter.api.BeforeAll;
import web.util.AbstractApiTest;

import java.io.File;

public class AbstractUsersApiTest extends AbstractApiTest
{
    @BeforeAll
    public static void doParentBeforeSuite()
    {
        AbstractApiTest.doParentBeforeSuite();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api/users")
                .build();
    }

    public String getPackageResourcePath(String filePath)
    {
        return "reqres" + File.separator + filePath;
    }
}
