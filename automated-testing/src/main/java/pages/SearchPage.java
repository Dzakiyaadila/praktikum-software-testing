package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    By searchBar = By.id("sb_form_q");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://www.bing.com/");
    }

    public void inputSearch(String keyword) {
        driver.findElement(searchBar).sendKeys(keyword);
    }

    public void submitSearch() {
        driver.findElement(searchBar).submit();
    }
}


//searchBar.submit();