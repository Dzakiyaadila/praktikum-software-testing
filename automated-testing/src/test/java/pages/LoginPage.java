package pages;

import base.BasePage;
import locators.LoginPageLocator;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsername(String username) {
        setText(LoginPageLocator.usernameField, username);
    }

    public void inputPassword(String password) {
        setText(LoginPageLocator.passwordField, password);
    }

    public void clickLoginButton() {
        click(LoginPageLocator.loginButton);
    }

    public void login(String username, String password) {

        inputUsername(username);
        inputPassword(password);
        clickLoginButton();
    }
}