package utils.webdriver;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverUtils extends RemoteWebDriver
{
    private WebDriver driver;

    public WebDriverUtils()
    {
        super();
        driver = WebDriverRunner.getWebDriver();
    }

    public JavascriptExecutorWrapper asJS()
    {
        return JavascriptExecutorWrapper.of(driver);
    }
}
