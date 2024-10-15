import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void setup() {

        com.codeborne.selenide.Configuration.browserSize = "1920x1080";
        com.codeborne.selenide.Configuration.pageLoadStrategy = "eager";
        com.codeborne.selenide.Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.browser = "chrome";

    }
}
