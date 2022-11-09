package utils;

import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class CommonActions {

    @SneakyThrows
    public static void scrollForElement(WebElement element, WebDriver drv) {
        ((JavascriptExecutor) drv).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(200);
    }

    public static void switchToTab(WebDriver drv, Integer num) {
        ArrayList<String> tab = new ArrayList<>
                (drv.getWindowHandles());
        drv.switchTo().window(tab.get(num));
    }
}
