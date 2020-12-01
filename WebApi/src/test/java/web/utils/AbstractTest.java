package web.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
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
