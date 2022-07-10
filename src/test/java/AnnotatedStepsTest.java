import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
public class AnnotatedStepsTest {

    private final String Repository = "eroshenkoam/allure-example";
    private final Integer Issue_Number = 76;

    @Test

    public void testWhithAnnotatedSteps() {

        WebSteps steps = new WebSteps();

        steps.openpage();
        steps.searchRepository(Repository);
        steps.openRepositoryLink(Repository);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(Issue_Number);

    }
}