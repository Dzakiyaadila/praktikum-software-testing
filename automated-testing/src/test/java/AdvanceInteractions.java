import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AdvanceInteractions {
    @Test
    public void searchTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/menu/");
        WebElement menu = driver.findElement(By.partialLinkText("Main Item 2"));
        Actions action = new Actions(driver);
        action.moveToElement(menu).perform();
        WebElement menu_sub = driver.findElement(By.partialLinkText("SUB SUB LIST"));
        action.moveToElement(menu_sub).perform();
        WebElement menu_sub1 = driver.findElement(By.partialLinkText("Sub Sub Item 1"));
        action.moveToElement(menu_sub1).perform();
        WebElement menu_sub_sub = driver.findElement(By.partialLinkText("Sub Sub Item 2"));
        action.moveToElement(menu_sub_sub).click();
    }
}
