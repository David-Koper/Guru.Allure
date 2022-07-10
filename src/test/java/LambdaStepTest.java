import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {

    private final String Repository = "eroshenkoam/allure-example";
    private final Integer Issue_Number = 76;

    @Test
    public void testGitHubIssueSearch() {
    SelenideLogger.addListener("allure",new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");});

        step("ищем репозиторий по имени " + Repository, () -> {
            $(".js-site-search-form").click();
            $(".input-sm").sendKeys(Repository);
            $(".input-sm").submit();});

        step("В результатах поиска переходим по ссылке репозитория " + Repository, () -> {
            $(By.linkText("eroshenkoam/allure-example")).click();});

        step("Открываем таб Issues", () -> {
        $(By.partialLinkText("Issues")).click();});

        step("Проверяем что существует Issue c номером " + Issue_Number, () -> {
        $(withText("#" + Issue_Number)).should(Condition.exist);});


    }

}
