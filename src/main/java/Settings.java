import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Settings {

    protected AndroidDriver driver;
    String URL = "http://127.0.0.1:4723/wd/hub";
    String deviceName = "emulator-5554";
    String androidVersion = "8.1";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", androidVersion);
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");

        File file = new File("src/main/resources/", "wikipedia.apk");
        capabilities.setCapability("app", file.getAbsolutePath());

        driver = new AndroidDriver(new URL(URL), capabilities);
    }

    @Test
    public void testStart(){
        System.out.println("Test completed");
    }

//    @AfterEach
//    public void testFinish() {
//        driver.quit();
//    }
}
