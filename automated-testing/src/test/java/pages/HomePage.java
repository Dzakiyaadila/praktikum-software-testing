package pages;

import base.BasePage;
import locators.LoginPageLocator;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getProductText() {
        return getText(LoginPageLocator.productText);
    }
}