import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Ex7 {
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
        capabilities.setCapability("orientation", "LANDSCAPE"); /** Добавил эту настройку */
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");

        File file = new File("src/main/resources/", "org.wikipedia.apk");
        capabilities.setCapability("app", file.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://" + AppiumServer + ":" + AppiumPort + "/wd/hub"), capabilities);
    }

    @Test
    public void testStart(){
        clickSearchInput();
    }
    @Test
    public void reOpenApp(){
        clickSearchInput();
    }
    @AfterEach
    public void finish(){
        driver.quit();
    }

    public void setWait(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void clickElement(By elementBy){
        setWait(elementBy);
        driver.findElement(elementBy).click();
    }
    public void clickSearchInput(){
        clickElement(By.id("org.wikipedia:id/search_container"));
    }

}
