package Tests.iOS;

import Settings.Android.Android_BaseTest;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iOSFirstTestAndroid extends Android_BaseTest {
    public iOSFirstTestAndroid(AppiumDriver driver) {
        super(driver);
    }

    public iOSFirstTestAndroid clickNextButton(){
        setWait(By.id("The free encyclopedia"));
        tapElement(By.xpath("//XCUIElementTypeStaticText[@name='Next']"));
        setWait(By.id("New ways to explore"));
        tapElement(By.xpath("//XCUIElementTypeStaticText[@name='Next']"));
        setWait(By.id("Search in over 300 languages"));
        tapElement(By.xpath("//XCUIElementTypeStaticText[@name='Next']"));
        return this;
    }
    public iOSFirstTestAndroid clickButtonGetStarted(){
        tapElement(By.xpath("//XCUIElementTypeStaticText[@name='Get started']"));
        return this;
    }
    public iOSFirstTestAndroid assertLogotypeIsVisible(){
        String xPath_wiki_logo = "//XCUIElementTypeButton[@name='wikipedia']";
        setWait(By.xpath(xPath_wiki_logo));
        WebElement wikipedia = driver.findElement(By.xpath(xPath_wiki_logo));
        Assertions.assertTrue(wikipedia.isDisplayed(), "Cant found Wikipedia logotype");
        return this;
    }
}
