package web.utils.matchers;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.specification.ResponseSpecification.*;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import static java.net.HttpURLConnection.*;

public class IsInteger extends BaseMatcher<Integer>
{
    @Override
    public void describeTo(Description description)
    {

    }

    @Override
    public boolean matches(Object o)
    {
        try
        {
            Integer.parseInt((String) o);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
