package web.util;

import io.restassured.specification.Argument;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matcher;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class BodyMatcher<T>
{
    private Matcher<T> matcher;
    private String format;
    private List<Argument> args;

    public BodyMatcher(Matcher<T> matcher, String format, Object... args)
    {
        this.matcher = matcher;
        this.format = format;
        this.args = Arrays.stream(args).map(Argument::withArg).collect(Collectors.toList());
    }

    public BodyMatcher(Matcher<T> matcher, Object... args)
    {
        this.matcher = matcher;
        this.format = StringUtils.EMPTY;
        this.args = Arrays.stream(args).map(Argument::withArg).collect(Collectors.toList());
    }
}
