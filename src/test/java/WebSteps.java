import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {




    @Step("Открываем_главную_страницу")
    public void openpage() {
        open("https://github.com");
    }
    @Step("Ищем репозиторий по имени {repository}")
    public void searchRepository(String repository) {
        $(".js-site-search-form").click();
        $(".input-sm").sendKeys(repository);
        $(".input-sm").submit();
    }
    @Step("В результатах поиска переходим по ссылке репозитория {repository}")
    public void openRepositoryLink(String repository) {
        $(By.linkText("eroshenkoam/allure-example")).click();
    }
    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $(By.partialLinkText("Issues")).click();
    }

    @Step("Проверяем что существует Issue c номером {issueNumber}")
    public void shouldSeeIssueWithNumber(Integer issueNumber) {
        $(withText("#" + issueNumber)).should(Condition.exist);
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
