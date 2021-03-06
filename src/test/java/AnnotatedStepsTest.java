import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static java.nio.charset.StandardCharsets.UTF_8;
public class AnnotatedStepsTest {

    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final Integer ISSUE_NUMBER = 76;

    @Test

    public void testWhithAnnotatedSteps() {

        WebSteps steps = new WebSteps();

        steps.openpage();
        steps.searchRepository(REPOSITORY);
        steps.openRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);

    }
}