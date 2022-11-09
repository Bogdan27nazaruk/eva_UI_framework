package pages;

import Elements.HomeElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePage extends HomeElements {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Set search article")
    public HomePage setSearchArticle(String article) {
        getSearchField().sendKeys(article);
        return this;
    }

    @Step("Click evarianty button")
    public HomePage clickEvariantyBtn() {
        getEvariantyBtn().click();
        return this;
    }

    @Step("Click add to basket first goods")
    public HomePage clickFirstToBasketBtn() {
        getToBasketBtn().get(0).click();
        return this;
    }

    @Step("Click make order button")
    public HomePage clickMakeOrderBtn() {
        getMakeOrderBtn().click();
        return this;
    }
}
