package Settings.SeleniumFramework;


import Tests.MOBILE_WEB.Ex17;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestBaseSelenium {

    protected WebDriver driver;
    public Ex17 ex17;


    @BeforeEach
    @Step("Запускаю веб-драйвер и сессию")
    public void setUp(){
        initializeMobileDriver();
        driver.get("https://en.m.wikipedia.org/");
        ex17 = PageFactory.initElements(driver, Ex17.class);

    }
    @AfterEach
    @Step("Завершаю веб-драйвер и сессию")
    public void finish(){
        driver.quit();
    }

    public WebDriver initializeMobileDriver(){
        WebDriverManager.chromedriver().setup();
        try {
            this.driver = new ChromeDriver(mobileOptions());
        }catch (Exception e){
            e.printStackTrace();
        }
        return driver;
    }

    private ChromeOptions mobileOptions(){
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 390);
        deviceMetrics.put("height", 844);
        deviceMetrics.put("pixelRatio", 3.0);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 8.0.0;" +
                "Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/67.0.3396.99 Mobile Safari/537.36");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=390,844");
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        return chromeOptions;
    }
}
