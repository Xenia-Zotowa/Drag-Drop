package guru.qa;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSolutionsEnterprizeTests {

    @Test

    void openEnterprizeWithTheHelpHover() {
        //Открыть GitHub
        Selenide.open("https://github.com/");
        // Открыть Enterprize с помощью команды hover
        Selenide.$("nav").$(Selectors.byTagAndText("button","Solutions")).hover();
        Selenide.$("[href='/enterprise']").click();
        //Найти заголовок The AI-powered developer platform
        Selenide.$("#hero-section-brand-heading").shouldHave(Condition.text("The AI-powered developer platform"));


    }
}
