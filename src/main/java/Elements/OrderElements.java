package Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class OrderElements extends AbstractBasePage {
    protected OrderElements(WebDriver driver) {
        super(driver);
    }

    public WebElement getCityField() {
        return getVisibilityElementByXpath("(//div[@class='sf-input__wrapper'])[1]/input");
    }

    public WebElement getKyivCityBtn() {
        return getClickableElementByXpath("//a[text()= 'Київ, місто, Київська']");
    }

    public WebElement getDepartmentField() {
        return getVisibilityElementByXpath("//span[@class='v-ui-select-custom-combobox']/input");
    }

    public WebElement getFirstDepartment() {
        return getClickableElementByXpath("//ul[@class='v-ui-select-custom-combobox__list']//li");
    }

    public WebElement getPhoneNumberField() {
        return getVisibilityElementByXpath("(//div[@class='sf-input__wrapper'])[2]//input");
    }

    public WebElement getNameField() {
        return getVisibilityElementByXpath("(//div[@class='sf-input__wrapper'])[3]//input");
    }

    public WebElement getLastNameField() {
        return getVisibilityElementByXpath("(//div[@class='sf-input__wrapper'])[4]//input");
    }

    public WebElement getPatronymicNameField() {
        return getVisibilityElementByXpath("(//div[@class='sf-input__wrapper'])[5]//input");
    }

    public WebElement getMailField() {
        return getVisibilityElementByXpath("(//div[@class='sf-input__wrapper'])[6]//input");
    }

    public WebElement getConfirmOrderBtn() {
        return getClickableElementByXpath("//div[@class='actions']/button");
    }

    public WebElement getOrderNumber() {
        return getVisibilityElementByXpath("//div[@class='header__thank']/strong");
    }

    public WebElement getTrackingOrderBtn() {
        return getClickableElementByXpath("//div[@class='shipping']//button");
    }
}
