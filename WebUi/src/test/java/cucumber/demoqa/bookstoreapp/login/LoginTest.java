package cucumber.demoqa.bookstoreapp.login;

import cucumber.demoqa.bookstoreapp.login.page.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.AbstractTest;
import util.reportportal.RPScreenshooter;
import util.webdriver.WebDriverWrapper;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static util.operation.OperationUtils.ifException;

public class LoginTest extends AbstractTest<LoginPage>
{
    @Given("user = {string} and password = {string}")
    public void userAndPassword(String user, String password)
    {
        page.fillUserName(user)
                .fillPassword(password);
    }

    @When("Login button pressed")
    public void loginButtonPressed()
    {
        page.clickLoginButton();
    }

    @Then("user succesfully logged in")
    public void userSuccesfullyLoggedIn()
    {
        sleep(2);
        assertEquals("https://demoqa.com/profile", new WebDriverWrapper().asJS().getWindowLocationHref());
    }
}
