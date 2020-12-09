package util.reportportal;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import util.AbstractTest;
import util.webdriver.Screenshooter;

@Log4j2
public class RPScreenshooter extends Screenshooter
{
    public RPScreenshooter(AbstractTest<?> test)
    {
        super(test);
    }

    @SneakyThrows
    public void sendScreenshot()
    {
        var screenshotName = super.takeScreenshot();
        log.error("exception happened, see screenshot: " + screenshotName);
    }

    @SneakyThrows
    public void run()
    {
        sendScreenshot();
    }
}
