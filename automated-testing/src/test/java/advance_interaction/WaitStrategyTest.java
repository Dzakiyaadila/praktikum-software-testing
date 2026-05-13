package advance_interaction;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WaitStrategyTest {

    WebDriver driver;


    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }
//    @Test
//    void openWebsite() {
//
//        Assertions.assertTrue(driver.getTitle().contains("Test Exceptions"));
//    }

    @Test
    @DisplayName("TC1 - NoSuchElementException")
    void testCase1Fail() {

        driver.findElement(By.id("add_btn")).click();
        WebElement row2 = driver.findElement(By.id("row2"));
        Assertions.assertTrue(row2.isDisplayed());
    }
    @Test
    @DisplayName("TC1 - Fixed with Thread.sleep")
    void testCase1Sleep() throws InterruptedException {

        driver.findElement(By.id("add_btn")).click();

        Thread.sleep(6000);

        WebElement row2 =
                driver.findElement(By.id("row2"));

        Assertions.assertTrue(row2.isDisplayed());
    }


    @AfterEach
    void tearDown() {

//        driver.quit();
    }
}
