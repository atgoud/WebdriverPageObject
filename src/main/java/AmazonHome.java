import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by twer on 7/17/14.
 */
public class AmazonHome {
    private final WebDriver webdriver;

    public AmazonHome(WebDriver webdriver) {
        this.webdriver = webdriver;
    }


    public void search(String searchText) {
        webdriver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchText);
        webdriver.findElement(By.cssSelector("#nav-searchbar > div.nav-submit-button.nav-sprite > input")).click();
    }
}
