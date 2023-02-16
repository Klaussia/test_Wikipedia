import io.appium.java_client.MobileElement;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex2 {

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
        fillText(By.id("org.wikipedia:id/search_src_text"), "Java");    /** Для проверки */
//        assertElementHasText(By.id("org.wikipedia:id/search_src_text"), "Search…", "This line does not contain the required text");
        hideKeyboard();
        getSize();
    }


    public void check(){
        List element = driver.findElements(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']"));


    }

    public void getSize(){
        List<MobileElement> elementList = (List<MobileElement>) driver.findElements(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']"));
        for (MobileElement mobileElement : elementList){
            System.out.println(mobileElement.getText());
        }
        assertTrue(elementList.stream().allMatch(mobileElement -> mobileElement.findElements(By.xpath("")).contains("")));
    }
    public void checkWord(){
        String check = "Java";
    }


    public void setWait(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void clickElement(By elementBy){
        setWait(elementBy);
        driver.findElement(elementBy).click();
    }
    public void assertElementHasText(By elementBy, String checkWord, String error_message){
        setWait(elementBy);
        WebElement element = driver.findElement(elementBy);
        String getWord = element.getText();
        String yourWord = "Line contain: " + getWord + " word";
        System.out.println(yourWord);
        Assertions.assertEquals(checkWord, getWord, error_message);
    }

    public void fillText(By elementBy, String text){
        setWait(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public void hideKeyboard(){
       driver.hideKeyboard();
    }

}
