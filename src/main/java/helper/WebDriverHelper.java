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
import org.testng.Assert;

import java.time.Duration;



    public  class WebDriverHelper extends CorePage {
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
                logger.warn("❌ Element not found");
                driver.quit();
                Assert.fail("Test failed: Element not found for ID: " + elementID);  // Fails the test immediately
            }

            logger.info("✔ Element found successfully");
            return driver.findElement(By.id(elementID));
        }


        public WebElement findElementClassName(String elementClassName) {
            logger.info("🔍 Looking for element with ClassName: {}", elementClassName);

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(elementClassName)));
            } catch (Exception e) {
                logger.warn("❌ Element not found\n");
                driver.quit();
                Assert.fail("Test failed: Element not found for ClassName: " + elementClassName);  // Fails the test immediately
            }
            logger.info("✔ Element found successfully with xpath\n");
            return driver.findElement(By.className(elementClassName));
        }

        public WebElement findElementByXpath(String elementXpath) {

            logger.info("🔍 Looking for element with xpath: {}", elementXpath);

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
            } catch (Exception e) {
                logger.warn("❌ Element not found for xpath");
                driver.quit();
                Assert.fail("Test failed: Element not found for Xpath: " + elementXpath);  // Fails the test immediately

            }

            logger.info("✔ Element found successfully with xpath");
            return driver.findElement(By.xpath(elementXpath));
        }

    }

