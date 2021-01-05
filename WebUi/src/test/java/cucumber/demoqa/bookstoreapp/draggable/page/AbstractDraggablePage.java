package cucumber.demoqa.bookstoreapp.draggable.page;

import com.codeborne.selenide.SelenideElement;
import util.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

public class AbstractDraggablePage<Page extends AbstractDraggablePage<Page>> extends AbstractPage<Page>
{
    protected SelenideElement simpleTab = $("#draggableExample-tab-simple");
    protected SelenideElement axisTab = $("#draggableExample-tab-axisRestriction");
    protected SelenideElement containerTab = $("#draggableExample-tab-containerRestriction");
    protected SelenideElement cursorStyleTab = $("#draggableExample-tab-cursorStyle");

    public AbstractDraggablePage switchToSimpleTab()
    {
        simpleTab.click();
        return new SimpleDraggablePage();
    }

    public AbstractDraggablePage switchToAxisTab()
    {
        axisTab.click();
        return this;
    }

    public AbstractDraggablePage switchToContainerTab()
    {
        containerTab.click();
        return this;
    }

    public AbstractDraggablePage switchToCursorStyleTab()
    {
        cursorStyleTab.click();
        return this;
    }
}
