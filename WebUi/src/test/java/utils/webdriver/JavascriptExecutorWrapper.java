package utils.webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptExecutorWrapper implements JavascriptExecutor
{
    private JavascriptExecutor driver;

    public JavascriptExecutorWrapper(WebDriver driver)
    {
        this.driver = (JavascriptExecutor) driver;
    }

    public static JavascriptExecutorWrapper of(WebDriver driver)
    {
        return new JavascriptExecutorWrapper(driver);
    }

    @Override
    public Object executeScript(String script, Object... args)
    {
        return driver.executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args)
    {
        return driver.executeAsyncScript(script, args);
    }

    public <T> T executeScriptTyped(String script, Object... args)
    {
        return (T) executeScript(script, args);
    }

    public String getWindowLocationHref()
    {
        return executeScriptTyped("return window.location.href");
    }
}
