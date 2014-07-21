import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.util.concurrent.TimeUnit;

public class Timesheet {

    private WebDriver webdriver;

    @Test
    public void fillMyTimeSheet(){
        FirefoxProfile profile = new ProfilesIni().getProfile("ippvim5b.Selenium");
        webdriver = new FirefoxDriver(profile);
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.get("http://our.thoughtworks.com");

        String username = "xke";
        String password = "mySuncorp.14";
        webdriver.findElement(By.id("user-signin")).sendKeys(username);
        webdriver.findElement(By.id("pass-signin")).sendKeys(password);
        webdriver.findElement(By.id("signin-button")).click();
    }
}
