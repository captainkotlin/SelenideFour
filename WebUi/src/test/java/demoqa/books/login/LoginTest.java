package demoqa.books.login;

import com.codeborne.selenide.WebDriverRunner;
import demoqa.books.login.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import utils.AbstractTest;
import utils.webdriver.WebDriverUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("https://demoqa.com/profile", new WebDriverUtils().asJS().getWindowLocationHref());
    }
}
