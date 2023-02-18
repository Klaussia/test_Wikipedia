import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Ex6 {
    protected AndroidDriver driver;
    String AppiumServer = "127.0.0.1";
    String AppiumPort = "4723";
    String deviceName = "emulator-5554";
    String androidVersion = "8.1";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", androidVersion);
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");

        File file = new File("src/main/resources/", "org.wikipedia.apk");
        capabilities.setCapability("app", file.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://" + AppiumServer + ":" + AppiumPort + "/wd/hub"), capabilities);
    }
    String text = "Java";
    @Test
    public void testStart(){
        clickSearchInput();
        fillSearchNews(text);
        hideKeyboard();
        chooseFirstArticle();
        assertElementPresent();
    }

    public void clickSearchInput(){
        clickElement(By.id("org.wikipedia:id/search_container"));
    }
    public void fillSearchNews(String text){
        fillText(By.id("org.wikipedia:id/search_src_text"), text);
    }
    public void chooseFirstArticle(){
        clickElement(By.xpath("//android.widget.TextView[@text='"+ text +"']"));
    }
    public void assertElementPresent(){
        Assertions.assertTrue(driver.findElement(By.id("org.wikipedia:id/view_page_title_text")).isDisplayed(), "Title not found");
    }

    public void setWait(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void clickElement(By elementBy){
        setWait(elementBy);
        driver.findElement(elementBy).click();
    }
    public void hideKeyboard(){
        driver.hideKeyboard();
    }

    public void fillText(By elementBy, String text){
        setWait(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }
}
