package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OrderPage;
import pages.TrackingPage;

public class SmokeTests extends AbstractTestBase {

    @Test
    @Description("Create order and check status")
    public void checkCreateOrder() {
        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = new OrderPage(driver);
        TrackingPage trackingPage = new TrackingPage(driver);

        openUrl("https://eva.ua/");
        homePage
                .setSearchArticle("axe")
                .clickEvariantyBtn()
                .clickFirstToBasketBtn()
                .clickMakeOrderBtn();

        waitForLoaded("/checkout");
        assertTrue(getUrl().contains("/checkout"));

        orderPage
                .createOrder();

        waitForLoaded("/success");
        assertTrue(getUrl().contains("/success"));

        String orderNumber = orderPage.getTextOrderNumber();

        orderPage
                .clickTrackingOrder();

        trackingPage
                .setOrderNumber(orderNumber)
                .clickTrackingOrderBtn();

        assertEquals(trackingPage.getTextOrderStatus(),"Нове замовлення");
        sleep(1);
        assertTrue(getUrl().contains(orderNumber));
    }
}
