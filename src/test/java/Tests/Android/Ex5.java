package Tests.Android;
import Settings.Android.Android_BaseTest;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Ex5 extends Android_BaseTest {
    public Ex5(AppiumDriver driver) {
        super(driver);
    }


    public Ex5 clickSearchInput(){
        tapElement(By.id("org.wikipedia:id/search_container"));
        return this;
    }
    public Ex5 fillSearchNews(String text){
        fillText(By.id("org.wikipedia:id/search_src_text"), text);
        return this;
    }
    public Ex5 chooseFirstArticle(String firstArticle){
        tapElement(By.xpath("//android.widget.TextView[@text='"+ firstArticle +"']"));
        return this;
    }
    public Ex5 chooseSecondArticle(String secondArticle){
        tapElement(By.xpath("//android.widget.TextView[@text='"+ secondArticle +"']"));
        return this;
    }
    public Ex5 openMoreOptions(){
        elementIsDisplayed(By.xpath("//android.widget.ImageView[@content-desc='More options']"));
        tapElement(By.xpath("//android.widget.ImageView[@content-desc='More options']"));
        return this;
    }
    public Ex5 addToReadingList(){
        tapElement(By.xpath("//android.widget.TextView[@text='Add to reading list']"));
        return this;
    }
    public Ex5 pressButtonGotIt(){
        tapElement(By.xpath("//android.widget.TextView[@text='GOT IT']"));
        return this;
    }

    public Ex5 clearEntry(){
        clearEntryField(By.id("org.wikipedia:id/text_input"));
        return this;
    }
    public Ex5 fillNewName(String text){
        fillText(By.id("org.wikipedia:id/text_input"), text);
        return this;
    }
    public Ex5 pressOk(){
        tapElement(By.id("android:id/button1"));
        return this;
    }
    public Ex5 closeNews(){
        tapElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
        return this;
    }
    public Ex5 clickOnCreatedReadingList(){
        tapElement(By.id("org.wikipedia:id/item_container"));
        return this;
    }
    public Ex5 clickViewList(){
        tapElement(By.xpath("//android.widget.Button[@text='VIEW LIST']"));
        return this;
    }

    public Ex5 assertReadingListWithTwoNews(){
        elementIsDisplayed(By.id("org.wikipedia:id/item_reading_list_statistical_description"));
        WebElement checkText = driver.findElement(By.id("org.wikipedia:id/item_reading_list_statistical_description"));
        String check = checkText.getText();
        Assertions.assertTrue(check.startsWith("2 of 2"), "you wont have two news in reading list");
        return this;
    }
    public Ex5 longPressOnArticle(String secondArticle){
        longTouch(By.xpath("//android.widget.TextView[@text='"+ secondArticle +"']"));
        return this;
    }
    public Ex5 clickOnBasket(){
        tapElement(By.xpath("//android.widget.TextView[@content-desc=\"Delete selected items\"]"));
        return this;
    }

    public Ex5 assertReadingListWithOneNews(){
        elementIsDisplayed(By.id("org.wikipedia:id/item_reading_list_statistical_description"));
        WebElement checkText = driver.findElement(By.id("org.wikipedia:id/item_reading_list_statistical_description"));
        String check = checkText.getText();
        Assertions.assertTrue(check.startsWith("1 of 1"), "you wont have one news in reading list");
        return this;
    }
    public Ex5 clickOnArticle(String firstArticle){
        tapElement(By.xpath("//android.widget.TextView[@text='"+firstArticle+"']"));
        return this;
    }
    public Ex5 assertArticleTitle(String firstArticle){
        elementIsDisplayed(By.xpath("//*[@resource-id='org.wikipedia:id/view_page_title_text']"));
        WebElement title = driver.findElement(By.xpath("//*[@resource-id='org.wikipedia:id/view_page_title_text']"));
        String check = title.getText();
        Assertions.assertEquals(firstArticle,check,"i cant find title");
        return this;
    }
}
