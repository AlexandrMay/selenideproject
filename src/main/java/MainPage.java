import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.*;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static org.openqa.selenium.By.xpath;

public class MainPage {


    private By enterButton = xpath("//a[@title=\"Войти\"]");
    private By emailField = xpath("//input[@id=\"popupInputEnterMail\"]");
    private By passwordField = xpath("//input[@id=\"popupInputEnterPasw\"]");
    private By checkBox = xpath("//input[@type=\"checkbox\"]");
    String errorText = "//div[text()=\"Неверный логин или пароль\"]";
    private By enterButtonBig = xpath("//button[text()=\"Войти\"]");



    public MainPage open() {
        Selenide.open("/");
        return this;
    }

    public MainPage clickEnterButton () {
        $(enterButton).click();
        return this;
    }
    public MainPage enterEmail (String mail) {
        $(emailField).setValue(mail);
        return this;
    }
    public MainPage enterPassword (String password) {
        $(passwordField).setValue(password);
        return this;
    }
    public MainPage checkBoxClick () {
$(checkBox).waitUntil(visible, 5000).click();
        return this;
    }

    public MainPage clickMainButton() {
        $(enterButtonBig).click();
        System.out.println($(checkBox).isDisplayed());
        return this;
    }
    public boolean isErrorVisible (String message) {
        return $$(xpath(format(errorText, message))).get(0).isDisplayed();
    }
}
