package demoqa;

import demoqa.books.login.pages.LoginPage;
import demoqa.elements.textbox.pages.TextBoxPage;
import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Cucumber
@CucumberContextConfiguration
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { TextBoxPage.class, LoginPage.class})
public class TestDef
{
}
