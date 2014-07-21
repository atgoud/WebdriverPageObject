import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

public class SimpleTest {

    private WebDriver webdriver;
    private AmazonHome homePage;
    private SearchResultsPage searchResultsPage;

    @Before
    public void setup() {
        webdriver = new FirefoxDriver();
        webdriver.get("http://www.amazon.cn");
    }

    @After
    public void cleanup() {
        webdriver.manage().deleteAllCookies();
        webdriver.quit();
    }

    @Test
    public void testAddItemIntoCartFromSearchResults() {
        //Search keyword "Clean code"
        webdriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Clean code");
        webdriver.findElement(By.cssSelector("#nav-searchbar > div.nav-submit-button.nav-sprite > input")).click();

        //Click purchase at the second item in the result list
        webdriver.findElements(By.name("submit.addToCart")).get(1).click();

        //Switch to the last window opened
        for (String window : webdriver.getWindowHandles()) {
            webdriver.switchTo().window(window);
        }

        //Verify that the book name is Clean Code(评注版)
        assertThat(webdriver.findElement(By.className("hlb-item-title")).getText(), is("Clean Code(评注版)"));

        webdriver.findElement(By.linkText("进入结算中心")).click();
        assertThat(webdriver.getTitle(), containsString("亚马逊:登录"));
    }

    @Test
    public void testWithPageObject() throws Exception {
        homePage = new AmazonHome(webdriver);
        homePage.search("Clean code");

        searchResultsPage = new SearchResultsPage(webdriver);
        searchResultsPage.addItemIntoCartAtIndex(1);

        //Switch to the last window opened
        for (String window : webdriver.getWindowHandles()) {
            webdriver.switchTo().window(window);
        }



    }
}
