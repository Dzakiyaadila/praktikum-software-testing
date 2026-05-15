package advance_interaction;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class WaitStrategyTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @DisplayName("TC1 - Failed Without Wait")
    void testCase1Failed() {

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        driver.findElement(By.id("add_btn")).click();
        WebElement row2 = driver.findElement(By.id("row2"));

        assertTrue(row2.isDisplayed());
    }

    @Test
    @DisplayName("TC1-fixed using thread.sleep")
    void testCase1Sleep() throws InterruptedException {

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        driver.findElement(By.id("add_btn")).click();

        // hard weittt
        Thread.sleep(6000);
        WebElement row2 = driver.findElement(By.id("row2"));
        assertTrue(row2.isDisplayed());
    }

    @Test
    @DisplayName("TC1 - fix pakai explicit wait")
    void testCase1ExplicitWait() {

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.findElement(By.id("add_btn")).click();
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement row2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("row2")
                )
        );

        assertTrue(row2.isDisplayed());
    }

    //DI BAWAH INI ADALAH TC 5

    @Test
    @DisplayName("TC5 - TimeoutException")
    void testCase5Failed() {

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.findElement(By.id("add_btn")).click();

        // TIMEOUT TOO FAST
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement row2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("row2")
                )
        );
        assertTrue(row2.isDisplayed());
    }

    @Test
    @DisplayName("TC5 - Fixed Using Explicit Wait")
    void testCase5Fixed() {

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.findElement(By.id("add_btn")).click();

        // Timeout diperpanjang
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement row2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("row2")
                )
        );

        assertTrue(row2.isDisplayed());
    }

    @AfterEach
    void tearDown() {

//        driver.quit();

    }
}