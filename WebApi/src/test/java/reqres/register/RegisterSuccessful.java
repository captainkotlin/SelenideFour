package reqres.register;

import com.epam.reportportal.annotations.Step;
import com.epam.reportportal.annotations.TestCaseId;
import com.epam.reportportal.annotations.attribute.Attribute;
import com.epam.reportportal.annotations.attribute.Attributes;
import com.epam.reportportal.junit5.ReportPortalExtension;
import com.epam.reportportal.message.ReportPortalMessage;
import io.restassured.http.ContentType;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import web.utils.matchers.IsInteger;
import web.utils.matchers.IsZonedDateTime;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static org.hamcrest.Matchers.hasKey;

@Log4j2
public class RegisterSuccessful extends AbstractRegisterApiTest
{
    @Test
    @TestCaseId("This_is_test_case_id")
    //@Attributes(attributes = { @Attribute(key = "Wtf", value = "GG") })
    @Step(value = "StepMain", description = "Descr main")
    public void registerSuccessful()
    {
        var port = new ReportPortalMessage("Logged message");
        log.fatal(port);
        log.info(new ReportPortalMessage("Hello world"));
        step();
        given(requestSpecification)
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}")
                .expect()
                .log().all()
                .body("id", new IsInteger())
                .body("", hasKey("createdAt"))
                .body("createdAt", new IsZonedDateTime())
                .statusCode(HTTP_CREATED)
                .when()
                .post();
    }

    @Step(value = "stepVal", description = "step descr")
    public void step()
    {
        //throw new RuntimeException("Except");

    }
}
