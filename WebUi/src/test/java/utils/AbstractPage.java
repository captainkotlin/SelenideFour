package utils;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;

public abstract class AbstractPage<Page extends AbstractPage<Page>> {

    public SelenideElement typeText(SelenideElement webElement, String text)
    {
        webElement.click();
        webElement.sendKeys(text);
        return webElement;
    }

    public SelenideElement clickWithScrollTo(SelenideElement webElement)
    {
        webElement.scrollTo();
        webElement.click();
        webElement.click(ClickOptions.usingJavaScript());
        return webElement;
    }
}
