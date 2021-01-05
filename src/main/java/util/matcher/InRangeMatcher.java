package util.matcher;

import com.google.common.collect.Sets;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;


import java.util.Set;

public class InRangeMatcher<T> extends BaseMatcher<T>
{
    private final Set<T> range;

    public InRangeMatcher(T... range)
    {
        this.range = Sets.newHashSet(range);
    }

    public static <T> InRangeMatcher<T> inRange(T... range)
    {
        return new InRangeMatcher<>(range);
    }

    @Override
    public boolean matches(Object item)
    {
        return range.contains((T) item);
    }

    @Override
    public void describeTo(Description description)
    {
        description.appendText("item should be in range: " + range);
    }
}
