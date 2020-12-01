package tmp;

import lombok.extern.slf4j.Slf4j;
import web.utils.AbstractTest;

@Slf4j
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
