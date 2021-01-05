package util.webdriver;

import lombok.SneakyThrows;
import util.AbstractTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.screenshot;

public class Screenshooter implements Runnable
{
    private final AbstractTest<?> test;

    public <T> Screenshooter(AbstractTest<?> test)
    {
        this.test = test;
    }

    @SneakyThrows
    protected final String takeScreenshot()
    {
        var className = test.getClass().getName();
        var date = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss").format(LocalDateTime.now());
        var screenshotName = className + "_" + date;
        return screenshot(screenshotName);
    }

    @Override
    public void run()
    {
        takeScreenshot();
    }
}
