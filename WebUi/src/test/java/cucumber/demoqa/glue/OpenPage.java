package cucumber.demoqa.glue;

import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class OpenPage {
    @Given("url = {string}")
    public void url(String url)
    {
        open(url);
    }
}
