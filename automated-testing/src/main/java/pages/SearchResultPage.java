package pages;

import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}