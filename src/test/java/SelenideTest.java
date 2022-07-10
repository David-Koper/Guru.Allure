import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @Test
    public void testGitHubIssueSearch() {
        SelenideLogger.addListener("allure",new AllureSelenide());

        open("https://github.com/");
        $(".js-site-search-form").click();
        $(".input-sm").sendKeys("eroshenkoam/allure-example");

        $(".input-sm").submit();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("76")).should(Condition.exist);


    }

}
