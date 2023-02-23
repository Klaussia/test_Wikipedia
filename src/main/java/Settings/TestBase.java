package Settings;

import Tests.Ex3;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    protected AndroidDriver driver;
    private final static String AppiumServer = "127.0.0.1";
    private final static String AppiumPort = "4723";
    private final static String deviceName = "emulator-5554";
    private final static String androidVersion = "8.1";
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
    @AfterEach
    public void finishTest(){
        driver.quit();
    }
}
