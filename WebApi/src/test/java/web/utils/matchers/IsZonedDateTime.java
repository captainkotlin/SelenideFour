package web.utils.matchers;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.specification.ResponseSpecification.*;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static java.net.HttpURLConnection.*;

public class IsZonedDateTime extends BaseMatcher<String>
{
    @Override
    public boolean matches(Object o)
    {
        try
        {
            ZonedDateTime.parse((String) o);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public void describeTo(Description description)
    {
        description.appendText("Should be date time, e.g: 2020-11-20T08:38:00.235Z");
    }
}
