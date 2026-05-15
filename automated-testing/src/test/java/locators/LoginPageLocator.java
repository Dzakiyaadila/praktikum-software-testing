package locators;

import org.openqa.selenium.By;

public class LoginPageLocator {

    public static By usernameField =
            By.id("user-name");

    public static By passwordField =
            By.id("password");

    public static By loginButton =
            By.id("login-button");

    public static By productText =
            By.xpath("//span[text()='Products']");
}