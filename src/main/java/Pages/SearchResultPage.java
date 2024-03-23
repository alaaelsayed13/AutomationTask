package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage {
    private WebDriver driver;
    private By nextPageLink = By.xpath("//a[@title='Next page']");
    private By searchResultItems = By.xpath("//li[@class='b_algo']");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getNumberOfSearchResults() {
        List<WebElement> searchResults = driver.findElements(searchResultItems);
        return searchResults.size();
    }
    public void goToNextPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(nextPageLink));
        driver.findElement(nextPageLink).click();
    }
}
