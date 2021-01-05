package cucumber.demoqa.bookstoreapp.draggable.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Point;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class SimpleDraggablePage extends AbstractDraggablePage<SimpleDraggablePage>
{
    private SelenideElement draggable = $("#dragBox");

    public Point getDraggableCoords()
    {
        switchToSimpleTab();
        return draggable.getCoordinates().onPage();
    }

    public SimpleDraggablePage dragAndDropByOffset(int x, int y)
    {
        return dragAndDropByOffset(draggable, x, y);
    }
}
