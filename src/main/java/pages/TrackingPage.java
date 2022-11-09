package pages;

import Elements.TrackingElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TrackingPage extends TrackingElements {
    public TrackingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Set order number")
    public TrackingPage setOrderNumber(String orderNumber) {
        getOrderNumberField().sendKeys(orderNumber);
        return this;
    }

    @Step("Click tracking order button")
    public TrackingPage clickTrackingOrderBtn() {
        getTrackingOrderBtn().click();
        return this;
    }

    @Step("Get order status")
    public String getTextOrderStatus() {
        return getOrderStatus().getText();
    }
}
