package cucumber.demoqa.bookstoreapp.login.page;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;
import util.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

@Component
public class LoginPage extends AbstractPage<LoginPage>
{
    private final SelenideElement userNameField = $("#userName");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("#login");

    public LoginPage fillUserName(String userName)
    {
        typeText(userNameField, userName);
        return this;
    }

    public LoginPage fillPassword(String password)
    {
        typeText(passwordField, password);
        return this;
    }

    public LoginPage clickLoginButton()
    {
        loginButton.click();
        return this;
    }
}
