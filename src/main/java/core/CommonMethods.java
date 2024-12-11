package core;

import core.BasePage;
import enums.ConfigKey;
import org.openqa.selenium.WebDriver;

public class CommonMethods extends BasePage {
     WebDriver driver;

    public CommonMethods(WebDriver driver) {
        super(driver);
    }

    public static void invokeBrowser(WebDriver driver) {
        driver.manage().window().maximize();
        driver.navigate().to(ConfigKey.BaseUrl.getKey());
    }
}
