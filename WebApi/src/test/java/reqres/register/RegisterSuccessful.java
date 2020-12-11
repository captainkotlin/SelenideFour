package reqres.register;

import com.epam.reportportal.annotations.Step;
import com.epam.reportportal.annotations.TestCaseId;
import com.epam.reportportal.message.ReportPortalMessage;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.XmlConfig;
import io.restassured.http.ContentType;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.hasKey;
import static util.matcher.ParseableAsInteger.parseableAsInteger;
import static util.matcher.InRangeMatcher.inRange;
import static util.matcher.ParseableAsZonedDateTime.parseableAsZonedDateTime;

@Log4j2
public class RegisterSuccessful extends AbstractRegisterApiTest
{
    @Test
    @TestCaseId("This_is_test_case_id")
    @Step(value = "StepMain", description = "Descr main")
    public void registerSuccessful()
    {
        given(requestSpecification)
                .config(RestAssuredConfig.config().xmlConfig(XmlConfig.xmlConfig().with().namespaceAware(true)))
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
                .expect()
                .log().all()
                .body("id", parseableAsInteger())
                .body("", hasKey("createdAt"))
                .body("createdAt", parseableAsZonedDateTime())
                .statusCode(inRange(HTTP_OK, HTTP_CREATED))
                .when()
                .post();
    }
}
