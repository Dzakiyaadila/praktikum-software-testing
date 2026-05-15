package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    @Test
    @DisplayName("Login Success")
    void testLoginSuccess() {

        loginPage.login("standard_user", "secret_sauce");

        assertEquals("Products", homePage.getProductText());
    }

    @AfterEach
    void tearDown() {

//        driver.quit();

    }
}