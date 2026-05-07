import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SauceDemoLocatorPractice {

    public static void main(String[] args) throws InterruptedException {

        // Setup
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        //1. locators pakai name

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
//        Thread.sleep(1000);
        driver.findElement(By.name("login-button")).click();
        Thread.sleep(3000);

        //balik ke halaman login

        driver.navigate().back();
        Thread.sleep(2000);


        //2. locators pakai class

        List<WebElement> inputClass = driver.findElements(By.className("input_error"));
        inputClass.get(0).sendKeys("standard_user");
        inputClass.get(1).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        Thread.sleep(3000);

        //balik ke halaman login
        driver.navigate().back();
        Thread.sleep(2000);

        //3. locators menggunakan tag

        List<WebElement> inputTag = driver.findElements(By.tagName("input"));
        inputTag.get(0).sendKeys("standard_user");
        inputTag.get(1).sendKeys("secret_sauce");
        inputTag.get(2).click();
        Thread.sleep(3000);

        //balik ke halaman login
        driver.navigate().back();
        Thread.sleep(2000);

        //4. pakai xpath

        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(3000);

        //balik
        driver.navigate().back();
        Thread.sleep(2000);

        //funtion - (contains)

        driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[contains(@id,'login')]")).click();
        Thread.sleep(3000);

        //reset
        driver.navigate().back();
        Thread.sleep(2000);

        //function starts-with

        driver.findElement(By.xpath("//input[starts-with(@id,'user')]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[starts-with(@id,'pass')]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[starts-with(@id,'login')]")).click();
        Thread.sleep(3000);

        //reset

        driver.navigate().back();
        Thread.sleep(2000);

        //xpath axes

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='user-name']/following::input[1]"))
                .sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='password']/following::input[1]")).click();
        Thread.sleep(3000);

        //tutup bowser
        Thread.sleep(3000);

//        driver.quit();
    }
}