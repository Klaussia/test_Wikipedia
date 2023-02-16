import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Ex5 {
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
    String text = "Coffee Lake";
    String text_01 = "Milky Way";
    @Test
    public void testStart(){
        clickSearchInput();
        fillSearchNews(text);
        hideKeyboard();
        chooseFirstArticle();
        openMoreOptions();
        addToReadingList();
        pressButtonGotIt();
        clearEntry();
        fillNewName("Reading List");
        pressOk();
        closeNews();
        clickSearchInput();
        fillSearchNews(text_01);
        hideKeyboard();
        chooseSecondArticle();
        openMoreOptions();
        addToReadingList();
        clickOnCreatedReadingList();
        clickViewList();
        assertReadingListWithTwoNews();
        longTouch();
        clickOnBasket();
        assertReadingListWithOneNews();
        clickOnArticle();
        assertArticleTitle();
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
    public void chooseSecondArticle(){
        clickElement(By.xpath("//android.widget.TextView[@text='"+ text_01 +"']"));
    }
    public void openMoreOptions(){
        elementIsDisplayed(By.xpath("//android.widget.ImageView[@content-desc='More options']"));
        clickElement(By.xpath("//android.widget.ImageView[@content-desc='More options']"));
    }
    public void addToReadingList(){
        clickElement(By.xpath("//android.widget.TextView[@text='Add to reading list']"));
    }
    public void pressButtonGotIt(){
        clickElement(By.xpath("//android.widget.TextView[@text='GOT IT']"));
    }

    public void clearEntry(){
        clearEntryField(By.id("org.wikipedia:id/text_input"));
    }
    public void fillNewName(String text){
        fillText(By.id("org.wikipedia:id/text_input"), text);
    }
    public void pressOk(){
        clickElement(By.id("android:id/button1"));
    }
    public void closeNews(){
        clickElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
    }
    public void clickOnCreatedReadingList(){
        clickElement(By.id("org.wikipedia:id/item_container"));
    }
    public void clickViewList(){
        clickElement(By.xpath("//android.widget.Button[@text='VIEW LIST']"));
    }

    public void assertReadingListWithTwoNews(){
        elementIsDisplayed(By.id("org.wikipedia:id/item_reading_list_statistical_description"));
        WebElement checkText = driver.findElement(By.id("org.wikipedia:id/item_reading_list_statistical_description"));
        String check = checkText.getText();
        Assertions.assertTrue(check.startsWith("2 of 2"), "you wont have two news in reading list");
    }
    public void clickOnBasket(){
        clickElement(By.xpath("//android.widget.TextView[@content-desc=\"Delete selected items\"]"));
    }

    public void assertReadingListWithOneNews(){
        elementIsDisplayed(By.id("org.wikipedia:id/item_reading_list_statistical_description"));
        WebElement checkText = driver.findElement(By.id("org.wikipedia:id/item_reading_list_statistical_description"));
        String check = checkText.getText();
        Assertions.assertTrue(check.startsWith("1 of 1"), "you wont have one news in reading list");
    }
    public void clickOnArticle(){
        clickElement(By.xpath("//android.widget.TextView[@text='"+text+"']"));
    }
    public void assertArticleTitle(){
        elementIsDisplayed(By.xpath("//*[@resource-id='org.wikipedia:id/view_page_title_text']"));
        WebElement title = driver.findElement(By.xpath("//*[@resource-id='org.wikipedia:id/view_page_title_text']"));
        String check = title.getText();
        Assertions.assertEquals(text,check,"i cant find title");
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
    public void clearEntryField(By elementBy){
        setWait(elementBy);
        driver.findElement(elementBy).clear();
    }
    public void elementIsDisplayed(By elementBy){
        setWait(elementBy);
        Assertions.assertTrue(driver.findElement(elementBy).isDisplayed(), "Element not found");

    }

    public void longTouch() {
        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='"+ text_01 +"']"));
        int x = element.getRect().x + (element.getSize().width) / 2;
        double y = element.getRect().y + (element.getSize().height / 2);
        double end_y = element.getRect().y + (element.getSize().height / 2);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longTouch = new Sequence(finger, 1);
        longTouch.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(), x,(int)y));
        longTouch.addAction(finger.createPointerDown(0));
        longTouch.addAction(finger.createPointerMove(Duration.ofMillis(300),PointerInput.Origin.viewport(), x,(int)end_y));
        driver.perform(Arrays.asList(longTouch));
    }
}
