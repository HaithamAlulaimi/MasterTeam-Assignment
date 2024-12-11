package helper;

import core.CorePage;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class ActionsAssertion extends CorePage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public ActionsAssertion(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void click(WebElement webElement) {

        softAssert.assertNotNull(webElement, "WebElement is null, cannot perform click.");

        if (webElement != null) {
            softAssert.assertTrue(webElement.isDisplayed(), "Element is not visible!");
            softAssert.assertTrue(webElement.isEnabled(), "Element is not enabled!");
        }

        if (webElement != null && webElement.isDisplayed() && webElement.isEnabled()) {
            webElement.click();
            System.out.println("Successfully clicked the element.");
        }
    }
}
