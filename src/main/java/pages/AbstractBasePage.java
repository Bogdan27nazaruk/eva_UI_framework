package pages;

import common.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;
import java.util.List;

public abstract class AbstractBasePage extends Base {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final int BASE_WAIT = 15;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(BASE_WAIT));
    }

    protected void openUrl(String url) {
        driver.get(url);
        WaitUtils.forPageLoaded(driver);
    }

    protected List<WebElement> getVisibilityOfElementsByXpath(String locator) {
        return waitVisibilityOfElementsLocated(By.xpath(locator));
    }

    protected List<WebElement> waitVisibilityOfElementsLocated(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (WebDriverException e) {
            fail("No visibility list element: " + locator);
            return null;
        }
    }

    protected WebElement findElementByXpath(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    protected List<WebElement> findElementsByXpath(String locator) {
        return driver.findElements(By.xpath(locator));
    }

    protected WebElement getVisibilityElementByXpath(String locator) {
        return waitVisibilityOfElementLocated(locator);
    }

    protected WebElement getClickableElementByXpath(String locator) {
        return waitClickableElementByXpath(locator);
    }

    protected WebElement waitClickableElementByXpath(String locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        } catch (WebDriverException e) {
            fail("No clickable element: " + locator);
            return null;
        }
    }

    protected WebElement waitVisibilityOfElementLocated(String locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            fail("No visibility element: " + locator);
            return null;
        }
    }

    protected boolean waitInvisibilityOfElementLocated(String locator) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
        } catch (WebDriverException e) {
            fail("Element is visibility: " + locator);
            return false;
        }
    }

    public void clearField(WebElement element) {
        try {
            element.click();
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        } catch (Exception ignore) {
        }
    }
}
