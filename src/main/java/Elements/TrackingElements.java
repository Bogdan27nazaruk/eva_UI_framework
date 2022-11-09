package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class TrackingElements extends AbstractBasePage {
    protected TrackingElements(WebDriver driver) {
        super(driver);
    }

    public WebElement getOrderNumberField() {
        return getVisibilityElementByXpath("//div[@class='sf-input sf-input tracking__input']//input");
    }

    public WebElement getTrackingOrderBtn() {
        return getClickableElementByXpath("//form[@class='tracking__form']//button");
    }

    public WebElement getOrderStatus() {
        return getVisibilityElementByXpath("//div[contains(@class, 'order-status tracking')]/span");
    }
}
