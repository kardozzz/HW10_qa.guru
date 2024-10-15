import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }
    @Step("Ищем репозиторий {repo}")
    public void SearchForRepository(String repo){
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }
    @Step("Кликаем по ссылке репозитория ")
    public void clickOpenRepositoryLink(String repo){
        $(linkText(repo)).click();
    }
    @Step("Открываем Tab Issues")
    public void openIssueTab(){
        $(".issues-tab").click();
    }
    @Step("Проверяем наличие Issue с текстом ")
    public void shouldSeeIssueWitchText(String issue){
        $(withText(issue)).should(Condition.exist);
    }
}
