package cucumber.demoqa.elements.textbox.page;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;
import util.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

@Component
public class TextBoxPage extends AbstractPage
{
    private final SelenideElement fullNameField = $("#userName");
    private final SelenideElement emailField = $("#userEmail");
    private final SelenideElement currentAddressField = $("#currentAddress[class=form-control]");
    private final SelenideElement permanentAddressField = $("#permanentAddress[class=form-control]");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement name = $("#name");
    private final SelenideElement email = $("#email");
    private final SelenideElement currentAddress = $("#currentAddress[class=mb-1]");
    private final SelenideElement permanentAddress = $("#permanentAddress[class=mb-1]");

    public TextBoxPage typeFullName(String fullName)
    {
        typeText(fullNameField, fullName);
        return this;
    }

    public TextBoxPage typeEmail(String email)
    {
        typeText(emailField, email);
        return this;
    }

    public TextBoxPage typeCurrentAddress(String currentAddress)
    {
        typeText(currentAddressField, currentAddress);
        return this;
    }

    public TextBoxPage typePermanentAddress(String permanentAddress)
    {
        typeText(permanentAddressField, permanentAddress);
        return this;
    }

    public TextBoxPage clickSubmitButton()
    {
        clickWithScrollTo(submitButton);
        return this;
    }

    public String getNameText()
    {
        return name.getText();
    }

    public String getEmailText()
    {
        return email.getText();
    }

    public String getCurrentAddressText()
    {
        return currentAddress.getText();
    }

    public String getPermanentAddressText()
    {
        return permanentAddress.getText();
    }
}
