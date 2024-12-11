package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class CommonMethods extends BasePage {
     WebDriver driver;

    public CommonMethods(WebDriver driver) {
        super(driver);
    }

    public static void invokeBrowser(WebDriver driver) {
        driver.manage().window().maximize();
//        driver.navigate().to(BASE_URL.getKey());
    }
}
