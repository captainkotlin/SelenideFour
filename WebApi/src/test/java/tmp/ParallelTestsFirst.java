package tmp;


import lombok.extern.slf4j.Slf4j;
import web.utils.AbstractTest;

@Slf4j
public class ParallelTestsFirst extends AbstractTest
{

    public void testA() throws InterruptedException
    {
        log.info("TestA");
        log.info("TestA thread id = " + Thread.currentThread().getId());
        log.info("TestA hash = " + this.hashCode());
    }

    public void testB() throws InterruptedException
    {
        log.info("TestB");
        log.info("TestB thread id = " + Thread.currentThread().getId());
        log.info("TestB hash = " + this.hashCode());
    }
}
