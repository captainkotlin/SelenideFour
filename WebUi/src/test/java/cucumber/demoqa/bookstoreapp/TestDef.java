package cucumber.demoqa.bookstoreapp;

import cucumber.demoqa.bookstoreapp.draggable.page.SimpleDraggablePage;
import cucumber.demoqa.bookstoreapp.login.page.LoginPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(glue = { "cucumber.demoqa.bookstoreapp", "cucumber.demoqa.glue" }, plugin = { "pretty", "com.epam.reportportal.cucumber.ScenarioReporter" })
@SpringBootTest(classes = {LoginPage.class, SimpleDraggablePage.class})
public class TestDef
{
}
