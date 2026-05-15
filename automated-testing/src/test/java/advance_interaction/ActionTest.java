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

        // hover ke gambar pertama
        action.moveToElement(firstImg).perform();
        WebElement text = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        assertTrue(text.isDisplayed(), "Teks 'name: user1' tidak muncul!");
    }

    @Test
    @DisplayName("Tugas 1.2: Key Presses")
    void testKeyPress() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement inputField = driver.findElement(By.id("target"));

        // tekan tombol shift
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

        //drag box b (source) ke box a (target)
        action.dragAndDrop(source, target).perform();
        //assert box a = b
        assertEquals("B", source.findElement(By.tagName("header")).getText());
    }

    @AfterEach
    void tearDown() {
//        driver.quit();
    }
}