package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Hello world!
 *
 */
public class CorePage {
    private final WebDriver driver;

    public CorePage(WebDriver driver) {
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
