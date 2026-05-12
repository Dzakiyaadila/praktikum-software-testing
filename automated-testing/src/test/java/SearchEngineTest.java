import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SearchEngineTest {

    @Test
    public void searchTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bing.com/");

        WebElement searchBar = driver.findElement(By.id("sb_form_q"));

        Actions actions = new Actions(driver);
        actions.moveToElement(searchBar).click().sendKeys(Keys.ENTER).perform();

        String query = "ned stark";
        searchBar.sendKeys(query);

        searchBar.sendKeys(Keys.ENTER);

        // 5. Validasi hasil (title mengandung query)
        String title = driver.getTitle();
        Assertions.assertTrue(
                title.toLowerCase().contains("ned"),
                "Title tidak mengandung query"
        );

        // driver.quit();
    }
}


/**
 * tugas laprak, buat positive dan negatif
 * di saucedemo itu ada negative dan positifnya.
 * DOM itu apa?
 */