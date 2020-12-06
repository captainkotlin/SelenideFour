package utils;

import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class AbstractTest<Page extends AbstractPage<Page>>
{
    @Autowired
    protected Page page;

    public <T> void equalityAssert(Function<Page, T> mapper, T expectedValue)
    {
        assertThat(mapper.apply(page), equalTo(expectedValue));
    }
}
