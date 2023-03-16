package Settings.iOS;

import Settings.CrossPlatformClasses.TestBase;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class BaseIOSTest extends TestBase {

    public BaseIOSTest(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    protected void setWait(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    protected void tapElement(By elementBy){
        setWait(elementBy);
        driver.findElement(elementBy).click();
    }
    protected void fillText(By elementBy, String text){
        setWait(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }
    protected void clearEntryField(By elementBy){
        setWait(elementBy);
        driver.findElement(elementBy).clear();
    }
    protected void elementVisible(By elementBy){
        setWait(elementBy);
        driver.findElement(elementBy).isDisplayed();
    }
    protected void assertCountElementsOnPage(By elementBy){
        setWait(elementBy);
        List elements = driver.findElements(elementBy);
        System.out.println(elements.size());
        Assertions.assertEquals(8,elements.stream().count(), "The number of articles does not match ");
    }
    protected void assertSearchResultIsMissing(By elementBy){
        List elements = driver.findElements(elementBy);
        Assertions.assertTrue(elements.isEmpty(), "Search is not empty");
    }
    protected void scrollToElement(By elementBy){
        WebElement scroll = driver.findElement(elementBy);
        int centerX = scroll.getRect().x + (scroll.getSize().width/2);
        double startY = scroll.getRect().y + (scroll.getSize().height * 0.7);
        double endY = scroll.getRect().y + (scroll.getSize().height * -6.5);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipe = new Sequence(finger, 2);
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),centerX,(int)startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), centerX, (int)endY));
        driver.perform(Arrays.asList(swipe));
    }
    protected void elementIsDisplayed(By elementBy){
        setWait(elementBy);
        Assertions.assertTrue(driver.findElement(elementBy).isDisplayed(), "Element not found");
    }
    protected void longTouch(By elementBy) {
        WebElement element = driver.findElement(elementBy);
        int x = element.getRect().x + (element.getSize().width) / 2;
        double y = element.getRect().y + (element.getSize().height / 2);
        double end_y = element.getRect().y + (element.getSize().height / 2);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longTouch = new Sequence(finger, 1);
        longTouch.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(), x,(int)y));
        longTouch.addAction(finger.createPointerDown(0));
        longTouch.addAction(finger.createPointerMove(Duration.ofMillis(800),PointerInput.Origin.viewport(), x,(int)end_y));
        driver.perform(Arrays.asList(longTouch));
    }

    protected boolean testOne(String article){
        try {
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+article+"']"));
            return true;
        }catch (NoSuchElementException a){
            a.getCause();
            return false;
        }
    }
    protected boolean testTwo(String article){
        try {
            driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+article+"']"));
            return true;
        }catch (NoSuchElementException a){
            a.getCause();
            return false;
        }
    }
    protected void checkVisible(String One, String Two){
        if(testOne(One)){
            Assertions.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+One+"']")).isDisplayed(), Two + " is not Displayed");
            System.out.println("Visible only one article: " + One);
        }
        else if(testTwo(Two)){
            Assertions.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+Two+"']")).isDisplayed(), One + " is Not Displayed");
            System.out.println("Visible only one article: " + Two);
        }

    }


}
