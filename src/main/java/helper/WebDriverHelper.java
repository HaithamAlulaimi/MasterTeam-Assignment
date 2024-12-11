package helper;

import core.CorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WebDriverHelper extends CorePage {
    Logger logger = LoggerFactory.getLogger(WebDriverHelper.class);
    WebDriverWait wait;
    WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void visit(String url) {
        driver.get(url);
        wait.until(webDriver -> {
            String readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
            return "complete".equalsIgnoreCase(readyState);
        });
    }

    public WebElement findElementByID(String elementID) {
        logger.info("🔍 Looking for element with ID: {}", elementID);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementID)));
        } catch (Exception e) {
            logger.warn("❌ Element not found for ID: {}\n", elementID);
            e.printStackTrace();
            driver.close();
        }
        logger.info("✔ Element found successfully with ID: {}\n", elementID);

        return driver.findElement(By.id(elementID));
    }


    public WebElement findElementClassName(String elementClassName) {
        logger.info("🔍 Looking for element with ClassName: {}", elementClassName);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(elementClassName)));
        } catch (Exception e) {
            logger.warn("❌ Element not found for ClassName: {}\n", elementClassName);
            e.printStackTrace();
            driver.close();
        }
        logger.info("✔ Element found successfully with xpath: {}\n", elementClassName);
        return driver.findElement(By.className(elementClassName));
    }

    public WebElement findElementByXpath(String elementXpath) {

        logger.info("🔍 Looking for element with xpath: {}", elementXpath);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        } catch (Exception e) {
            logger.warn("❌ Element not found for xpath: {}\n", elementXpath);
            e.printStackTrace();
            driver.close();
        }

        logger.info("✔ Element found successfully with xpath: {}\n", elementXpath);
        return driver.findElement(By.xpath(elementXpath));
    }

}
