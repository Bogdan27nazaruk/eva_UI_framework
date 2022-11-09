package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

import java.util.List;

public class HomeElements extends AbstractBasePage {
    protected HomeElements(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchField() {
        return getVisibilityElementByXpath("//input[@type='search']");
    }

    public WebElement getEvariantyBtn() {
        return getClickableElementByXpath("//span[@class='m-search-bar__action']/button");
    }

    public List<WebElement> getToBasketBtn() {
        return getVisibilityOfElementsByXpath("//div[@class='product products__product-card']//span[contains(text(), 'До кошика')]");
    }

    public WebElement getMakeOrderBtn() {
        return getClickableElementByXpath("//div[@class='m-modal-microcart-totals__content']/following-sibling::button");
    }
}
