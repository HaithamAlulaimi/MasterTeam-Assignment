package helper;

import core.CorePage;
import org.openqa.selenium.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

public class ActionsAssertion extends CorePage {
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(ActionsAssertion.class);

    public ActionsAssertion(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void click(WebElement webElement,SoftAssert softAssert) {

        softAssert.assertNotNull(webElement, "WebElement is null, cannot perform click.\n");

        if (webElement != null) {
            softAssert.assertTrue(webElement.isDisplayed(), "Element is not visible!\n");
            softAssert.assertTrue(webElement.isEnabled(), "Element is not enabled!\n");
        }

        if (webElement != null && webElement.isDisplayed() && webElement.isEnabled()) {
            webElement.click();
            logger.info("✔ Successfully clicked the element.\n");
        }
    }

    public void sendKeys(WebElement webElement, String keysToSend, SoftAssert softAssert) {
        softAssert.assertNotNull(webElement, "WebElement is null, cannot perform click.\n");

        if (webElement != null) {
            softAssert.assertTrue(webElement.isDisplayed(), "Element is not visible!\n");
            softAssert.assertTrue(webElement.isEnabled(), "Element is not enabled!\n");
        }

        if (webElement != null && webElement.isDisplayed() && webElement.isEnabled()) {
            webElement.sendKeys(keysToSend);
            logger.info("✔ Successfully sent keys to element\n");
        }
    }

}
