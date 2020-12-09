package utils.matchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import static utils.matchers.OperationUtils.completesWithoutException;

public class ParseableAsInteger extends BaseMatcher<Integer>
{
    public static ParseableAsInteger parseableAsInteger()
    {
        return new ParseableAsInteger();
    }

    @Override
    public void describeTo(Description description)
    {

    }

    @Override
    public boolean matches(Object o)
    {
        return o instanceof Integer || completesWithoutException(() -> Integer.parseInt((String) o));
    }
}
