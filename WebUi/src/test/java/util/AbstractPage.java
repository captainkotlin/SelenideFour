package util;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.actions;

public abstract class AbstractPage<Page extends AbstractPage<Page>>
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

    public Page dragAndDropByOffset(SelenideElement webElement, int x, int y)
    {
        actions().dragAndDropBy(webElement, x, y).build().perform();
        return toPage();
    }

    private Page toPage()
    {
        return (Page) this;
    }
}
