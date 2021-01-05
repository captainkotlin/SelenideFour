package web.util;

import io.restassured.RestAssured;
import io.restassured.config.JsonConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class AbstractApiTest extends AbstractTest
{
    protected static RequestSpecification requestSpecification;

    @BeforeAll
    public static void doParentBeforeSuite()
    {
        AbstractTest.doParentBeforeSuite();
        RestAssured.config().jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.DOUBLE));
    }
}
