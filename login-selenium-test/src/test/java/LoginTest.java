import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    @Test
    public void loginSuccess () {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        WebElement form = driver.findElement(By.name("login-button"));
        form.submit();

        Assertions.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login gagal, tidak redirect ke halaman inventory"
        );

    }

    @Test
    public void loginFailed () {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"))
                .sendKeys("locked_out_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        WebElement form = driver.findElement(By.name("login-button"));
        form.submit();

        String errorMessage = driver.findElement(By.cssSelector("h3")).getText();
        /**
         * BISA PILIH SALAH SATU DI BAWAH INI
         */

//        Assertions.assertEquals(
//                "Epic sadface: Sorry, this user has been locked out.",
//                errorMessage,
//                "Pesan error tidak sesuai"
//        );
        Assertions.assertTrue(
                errorMessage.contains("Sorry"), "Pesan error tidak sesuai"

        );
    }
}
