package util;

import lombok.extern.log4j.Log4j2;
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Log4j2
public class AbstractTest<Page extends AbstractPage>
{
    @Autowired
    protected Page page;

    public <T> void equalityAssert(Function<Page, T> mapper, T expectedValue)
    {
        assertThat(mapper.apply(page), equalTo(expectedValue));
    }
}
