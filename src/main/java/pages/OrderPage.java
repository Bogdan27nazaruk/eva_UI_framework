package pages;

import Elements.OrderElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class OrderPage extends OrderElements {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select city")
    public OrderPage selectCity(String city) {
        getCityField().sendKeys(city);
        getKyivCityBtn().click();
        return this;
    }

    @Step("Select department")
    public OrderPage selectDepartment(String department) {
        getDepartmentField().sendKeys(department);
        getFirstDepartment().click();
        return this;
    }

    @Step("Set phone number")
    public OrderPage setPhoneNumber(String number) {
        getPhoneNumberField().sendKeys(number);
        return this;
    }

    @Step("Set first name")
    public OrderPage setFirstName(String name) {
        getNameField().sendKeys(name);
        return this;
    }

    @Step("Set last name")
    public OrderPage setLastName(String lastName) {
        getLastNameField().sendKeys(lastName);
        return this;
    }

    @Step("Set patronymic name")
    public OrderPage setPatronymicName(String patronymicName) {
        getPatronymicNameField().sendKeys(patronymicName);
        return this;
    }

    @Step("Set mail")
    public OrderPage setMail(String mail) {
        getMailField().sendKeys(mail);
        return this;
    }

    @Step("Click confirm order button")
    public OrderPage clickConfirmOrderBtn() {
        getConfirmOrderBtn().click();
        return this;
    }

    @Step("Create order")
    public OrderPage createOrder() {
        selectCity("Київ");
        selectDepartment("EVA 300:");
        setPhoneNumber("0980000000");
        setFirstName("Богдан");
        setLastName("Назарук");
        setPatronymicName("Вікторович");
        setMail("nnn@gmail.com");
        clickConfirmOrderBtn();
        return this;
    }

    @Step("Get order number")
    public String getTextOrderNumber() {
        return getOrderNumber().getText().replace("№", "");
    }

    @Step("Click tracking delivery order")
    public OrderPage clickTrackingOrder() {
        getTrackingOrderBtn().click();
        return this;
    }
}
