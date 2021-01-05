package util;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Log4j2
public class AbstractTest<Page extends AbstractPage<Page>>
{
    @Rule
    public ExpectedException thrown = getExpectedExceptionRule();

    @Autowired
    protected Page page;

    public <T> void equalityAssert(Function<Page, T> mapper, T expectedValue)
    {
        assertThat(mapper.apply(page), equalTo(expectedValue));
    }

    @SneakyThrows
    protected void sleep(int seconds)
    {
        Thread.sleep(seconds * 1000L);
    }

    private ExpectedException getExpectedExceptionRule()
    {
        var rule = ExpectedException.none();
        rule.expect(WebDriverException.class);
        return rule;
    }
}
