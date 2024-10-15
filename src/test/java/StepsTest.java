import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private final static String REPOSITORY = "kardozzz/HW10_qa.guru";
    private final static String ISSUE = "Test Issue";
    @Test
    void findIssueTests(){
        SelenideLogger.addListener("allure",new AllureSelenide());
        open("https://github.com/");
        $(".qb-input-query").click();
        $(".qb-input-query").sendKeys("kardozzz/HW10_qa.guru");
        $(".qb-input-query").submit();

        $(linkText("kardozzz/HW10_qa.guru")).click();
        $(".issues-tab").click();
        $(withText("Test Issue")).should(Condition.exist);

    }
    @Test
    void findIssueLambdaTests() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".qb-input-query").click();
            $(".qb-input-query").sendKeys(REPOSITORY);
            $(".qb-input-query").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем Tab Issues", () -> {
            $(".issues-tab").click();
        });
        step("Проверяем наличие Issue с текстом " + ISSUE, () -> {
            $(withText(ISSUE)).should(Condition.exist);
        });
    }
    @Test
    public void testAnnotationStepTests(){
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.SearchForRepository(REPOSITORY);
        steps.clickOpenRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWitchText(ISSUE);
    }
}
