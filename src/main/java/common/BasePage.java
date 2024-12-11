package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Hello world!
 *
 */
public class BasePage {
    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebDriver getDriver() {
        return driver;
    }


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
