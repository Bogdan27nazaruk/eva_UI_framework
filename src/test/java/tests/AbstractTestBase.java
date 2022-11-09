package tests;

import common.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WaitUtils;

import java.util.Set;

public abstract class AbstractTestBase extends Base {

    protected WebDriver driver;

    public void openUrl(String url) {
        driver.get(url);
        WaitUtils.forPageLoaded(driver);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quiteDriver() {
        driver.quit();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @Step
    public void waitForLoaded(String url) {
        WaitUtils.waitUrlContains(driver, url);
    }

    public void refreshSite() {
        driver.navigate().refresh();
        WaitUtils.forPageLoaded(driver);
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void close() {
        driver.close();
    }
}
