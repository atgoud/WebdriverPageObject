import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by twer on 7/17/14.
 */
public class SearchResultsPage {
    private final WebDriver webdriver;

    public SearchResultsPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void addItemIntoCartAtIndex(int index) {
        webdriver.findElements(By.name("submit.addToCart")).get(index).click();
    }
}
