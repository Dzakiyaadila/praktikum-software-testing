package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.SearchPage;
import pages.SearchResultPage;

public class SearchTest {

    @Test
    public void positiveSearchTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        SearchPage searchPage = new SearchPage(driver);

        searchPage.openPage();

        String keyword = "Joffrey Baratheon";
        searchPage.inputSearch(keyword);

        searchPage.submitSearch();

        SearchResultPage resultPage = new SearchResultPage(driver);

        Assertions.assertTrue(
                resultPage.getPageTitle().toLowerCase().contains("joff"),
                "Title tidak mengandung keyword"
        );

        driver.quit();
    }
}