package cucumber.demoqa.bookstoreapp.draggable;

import cucumber.demoqa.bookstoreapp.draggable.page.SimpleDraggablePage;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Point;
import util.AbstractTest;
import util.asserts.EqualityAssert;

import java.util.function.Function;

public class SimpleDraggableTest extends AbstractTest<SimpleDraggablePage>
{
    private Point initialDraggableCoords;
    private Integer maxDifferenceX;
    private Integer maxDifferenceY;

    @When("drag by x = {int} and y = {int} is performed")
    public void dragByXAndYIsPerformed(Integer x, Integer y)
    {
        this.maxDifferenceX = x;
        this.maxDifferenceY = y;
        initialDraggableCoords = page.getDraggableCoords();
        page.dragAndDropByOffset(x, y);
    }

    @Then("element changed coordinates accordingly")
    public void elementChangedCoordinatesAccordingly()
    {
        Point currentDraggableCoords = page.getDraggableCoords();
        checkDistanceMoved(currentDraggableCoords, Point::getX, maxDifferenceX);
        checkDistanceMoved(currentDraggableCoords, Point::getY, maxDifferenceY);
    }

    private void checkDistanceMoved(Point actual, Function<Point, Integer> mapper, int maxDifference)
    {
        new EqualityAssert<>(initialDraggableCoords, actual)
                .withMapper(mapper)
                .withSubtractor((c, d) -> c - d)
                .withExpectedDifference(maxDifference)
                .check();
    }
}
