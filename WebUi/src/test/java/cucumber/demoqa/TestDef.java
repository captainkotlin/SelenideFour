package cucumber.demoqa;

import cucumber.demoqa.bookstoreapp.draggable.page.SimpleDraggablePage;
import cucumber.demoqa.bookstoreapp.login.page.LoginPage;
import cucumber.demoqa.elements.textbox.page.TextBoxPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(plugin = { "pretty", "com.epam.reportportal.cucumber.ScenarioReporter" })
@SpringBootTest(classes = { TextBoxPage.class, LoginPage.class, SimpleDraggablePage.class})
public class TestDef
{
}