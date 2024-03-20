package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BingHomePage {
    private WebDriver driver;
    private By searchBox = By.name("q");

    public BingHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void search(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword + Keys.ENTER);
    }
}

