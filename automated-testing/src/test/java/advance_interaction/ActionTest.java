package advance_interaction;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.*;

public class ActionTest {
    WebDriver driver;
    Actions action;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Tugas 1.1: Hover")
    void testHover() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement firstImg = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));

        // Melakukan hover ke gambar pertama [cite: 15, 46]
        action.moveToElement(firstImg).perform();

        WebElement text = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        assertTrue(text.isDisplayed(), "Teks 'name: user1' tidak muncul!");
    }

    @Test
    @DisplayName("Tugas 1.2: Key Presses")
    void testKeyPress() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement inputField = driver.findElement(By.id("target"));

        // Menekan tombol SHIFT di dalam input [cite: 15, 49]
        inputField.click();
        action.keyDown(Keys.SHIFT).perform();

        WebElement result = driver.findElement(By.id("result"));
        assertEquals("You entered: SHIFT", result.getText());
    }

    @Test
    @DisplayName("Tugas 1.3: Drag and Drop")
    void testDragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        action.dragAndDrop(source, target).perform();

        // Assert box A sekarang berisi teks 'B' karena sudah bertukar
        assertEquals("B", source.findElement(By.tagName("header")).getText());
    }

    @AfterEach
    void tearDown() {
//        driver.quit();
    }
}