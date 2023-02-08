import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Settings {

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

        File file = new File("src/main/resources", "org.wikipedia.apk");
        capabilities.setCapability("app", file.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://" + AppiumServer + ":" + AppiumPort + "/wd/hub"), capabilities);
    }

    @Test
    public void testStart(){
        clickElement(By.id("org.wikipedia:id/search_container"));
//        fillText(By.id("org.wikipedia:id/search_src_text"), "Hello");    /** Для проверки */
        checkElement(By.id("org.wikipedia:id/search_src_text"));
    }

    public void setWait(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void clickElement(By elementBy){
        setWait(elementBy);
        driver.findElement(elementBy).click();
    }
    public void checkElement(By elementBy){
        setWait(elementBy);
        WebElement element = driver.findElement(elementBy);
        String getWord = element.getText();
        String checkWord = "Search…";
        String yourWord = "Line contain: " + getWord + " word";
        String error_message = "This line does not contain the required text: Your word is " + getWord;
        System.out.println(yourWord);
        Assertions.assertEquals(checkWord, getWord, error_message);
    }

    public void fillText(By elementBy, String text){
        setWait(elementBy);
//        Assertions.assertTrue(driver.findElement(elementBy).isDisplayed());
        driver.findElement(elementBy).sendKeys(text);
    }

}
