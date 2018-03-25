import com.codeborne.selenide.Condition;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

public class MainPageTest {

    private MainPage page;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\STORAGE\\geckodriver.exe");
        baseUrl = "https://telemart.ua";
    }

    @Test
    public void click() {
        page = new MainPage();
        page.open()
                .clickEnterButton()
                .enterEmail("test@test.mail")
                .enterPassword("123")
.checkBoxClick()
                .clickMainButton();
        page.isErrorVisible("Неверный логин или пароль");
    }
}
