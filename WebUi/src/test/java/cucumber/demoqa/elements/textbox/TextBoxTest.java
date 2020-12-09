package cucumber.demoqa.elements.textbox;

import cucumber.demoqa.elements.textbox.page.TextBoxPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.AbstractTest;

public class TextBoxTest extends AbstractTest<TextBoxPage>
{
    private String expectedFullName;
    private String expectedEmail;
    private String expectedCurrentAddress;
    private String expectedPermanentAddress;

    @When("requested fullName = {string}, email = {string}, currentAddr = {string}, permanentAddress = {string}")
    public void requestedFullNamePassCurrentAddrPermanentAddress(String fullName, String email, String currentAddress, String permanentAddress)
    {
        expectedFullName = fullName;
        expectedEmail = email;
        expectedCurrentAddress = currentAddress;
        expectedPermanentAddress = permanentAddress;
        page.typeFullName(expectedFullName)
                .typeEmail(expectedEmail)
                .typeCurrentAddress(expectedCurrentAddress)
                .typePermanentAddress(expectedPermanentAddress);
    }

    @And("submit button pressed")
    public void submitButtonPressed()
    {
        page.clickSubmitButton();
    }

    @Then("output div is correctly set")
    public void outputDivIsCorrectlySet()
    {
        equalityAssert(TextBoxPage::getNameText, "Name:" + expectedFullName);
        equalityAssert(TextBoxPage::getEmailText, "Email:" + expectedEmail);
        equalityAssert(TextBoxPage::getCurrentAddressText, "Current Address :" + expectedCurrentAddress);
        equalityAssert(TextBoxPage::getPermanentAddressText, "Permananet Address :" + expectedPermanentAddress);
    }
}
