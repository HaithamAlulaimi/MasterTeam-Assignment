package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Actions extends BasePage {
    WebDriverWait wait;
    WebDriver driver;

    public Actions(WebDriver driver) {
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
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementID)));
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();
        }
        return driver.findElement(By.id(elementID));
    }


    public WebElement findElementClassName(String elementClassName) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(elementClassName)));
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();
        }
        return driver.findElement(By.className(elementClassName));
    }

    public WebElement findElementByXpath(String elementXpath) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        } catch (Exception e) {
            e.printStackTrace();
            driver.close();
        }
        return driver.findElement(By.xpath(elementXpath));
    }
}
