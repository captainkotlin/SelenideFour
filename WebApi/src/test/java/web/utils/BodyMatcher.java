package web.utils;

import io.restassured.specification.Argument;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matcher;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.withArgs;

@Data
public class BodyMatcher
{
    private Matcher matcher;
    private String format;
    private List<Argument> args;

    public BodyMatcher(Matcher matcher, String format, Object... args)
    {
        this.matcher = matcher;
        this.format = format;
        this.args = Arrays.stream(args).map(Argument::withArg).collect(Collectors.toList());
    }

    public BodyMatcher(Matcher matcher, Object... args)
    {
        this.matcher = matcher;
        this.format = StringUtils.EMPTY;
        this.args = Arrays.stream(args).map(Argument::withArg).collect(Collectors.toList());
    }
}
