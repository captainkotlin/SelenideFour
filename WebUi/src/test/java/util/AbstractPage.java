package util;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;

public abstract class AbstractPage
{
    public SelenideElement typeText(SelenideElement webElement, String text)
    {
        webElement.click();
        webElement.sendKeys(text);
        return webElement;
    }

    public SelenideElement clickWithScrollTo(SelenideElement webElement)
    {
        webElement.scrollTo()
                .click(ClickOptions.usingJavaScript());
        return webElement;
    }
}
