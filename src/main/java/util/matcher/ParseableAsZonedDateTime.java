package util.matcher;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.time.ZonedDateTime;

import static util.operation.OperationUtils.completesWithoutException;

public class ParseableAsZonedDateTime extends BaseMatcher<String>
{
    public static ParseableAsZonedDateTime parseableAsZonedDateTime()
    {
        return new ParseableAsZonedDateTime();
    }

    @Override
    public boolean matches(Object o)
    {
        return completesWithoutException(() -> ZonedDateTime.parse((String) o));
    }

    @Override
    public void describeTo(Description description)
    {
        description.appendText("Should be date time, e.g: 2020-11-20T08:38:00.235Z");
    }
}
