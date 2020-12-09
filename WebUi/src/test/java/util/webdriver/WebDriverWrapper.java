package util.webdriver;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverWrapper extends RemoteWebDriver
{
    private WebDriver driver;

    public WebDriverWrapper()
    {
        super();
        driver = WebDriverRunner.getWebDriver();
    }

    public JavascriptExecutorWrapper asJS()
    {
        return JavascriptExecutorWrapper.of(driver);
    }
}
