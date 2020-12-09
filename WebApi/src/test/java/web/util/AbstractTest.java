package web.util;

import com.epam.reportportal.junit5.ReportPortalExtension;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@Log4j2
@ExtendWith(ReportPortalExtension.class)
public class AbstractTest
{
    @BeforeAll
    public static void doParentBeforeSuite()
    {
        log.info("Parent doBeforeAll");
    }

    @AfterAll
    public static void doParentAfterSuite()
    {
        log.info("Parent doAfterAll");
    }

    @BeforeEach
    public void doParentBeforeTest()
    {
        log.info("Parent doBeforeEach");
    }

    @AfterEach
    public void doParentAfterTest()
    {
        log.info("Parent doAfterEach");
    }
}
