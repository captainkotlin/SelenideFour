package tmp;

import lombok.extern.log4j.Log4j2;
import web.utils.AbstractTest;

@Log4j2
public class ParallelTestsSecond extends AbstractTest
{

    public void testC() throws InterruptedException
    {
        log.info("TestC");
        log.info("TestC thread id = " + Thread.currentThread().getId());
    }

    public void testB() throws InterruptedException
    {
        log.info("TestD");
        log.info("TestD thread id = " + Thread.currentThread().getId());
    }
}
