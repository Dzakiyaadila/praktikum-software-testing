import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchEngineTest {

    @Test
    public void searchTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bing.com/");

        WebElement search_bar = driver.findElement(By.id("sb_form_q"));

        search_bar.sendKeys("ned stark");

        WebElement form = driver.findElement(By.id("sb_form"));
        form.submit();

        //assertion title web apakah mengandung quweriehh????
        String title = driver.getTitle();
        Assertions.assertTrue(
                title.contains("ned"), "takdalaaa"
        );

//driver.quit();
    }
}


/**
 * tugas laprak, buat positive dan negatif
 * di saucedemo itu ada negative dan positifnya.
 *
 */