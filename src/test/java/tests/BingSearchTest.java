package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.BingHomePage;
import Pages.SearchResultPage;

public class BingSearchTest {
    private WebDriver driver;
    private BingHomePage homePage;
    private SearchResultPage searchResultPage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new BingHomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test
    public void testSearchResults() {
        homePage.open("https://www.bing.com");
        homePage.search("Vodafone");
        searchResultPage.goToNextPage();
        int numberOfResultsPage2 = searchResultPage.getNumberOfSearchResults();
        searchResultPage.goToNextPage();
        int numberOfResultsPage3 = searchResultPage.getNumberOfSearchResults();
        Assert.assertEquals(numberOfResultsPage2, numberOfResultsPage3,
                "Number of results on page 2 is not equal to page 3.");
        driver.quit();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

