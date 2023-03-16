package Tests.iOS;

import Settings.iOS.BaseIOSTest;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends BaseIOSTest {

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    public SearchPageObject skipStartScreen(){
        tapElement(By.xpath("//*[@name='Skip']"));
        return this;
    }
    public SearchPageObject tapOnSearchLine(){
        tapElement(By.id("Search Wikipedia"));
        return this;
    }
    public SearchPageObject fillTextInSearchLine(String foundArticle){
        fillText(By.id("Search Wikipedia"), foundArticle);
        return this;
    }
    public SearchPageObject chooseResult(String chooseResult){
        tapElement(By.xpath("//*[@name='"+chooseResult+"']"));
        return this;
    }
    public SearchPageObject saveArticle(){
        tapElement(By.id("Save for later"));
        return this;
    }
    public SearchPageObject backInSearch(){
        tapElement(By.id("Search"));
        return this;
    }
    public SearchPageObject clearText(){
        tapElement(By.id("Clear text"));
        return this;
    }
    public SearchPageObject pressButtonW(){
        tapElement(By.xpath("//*[@name='W']"));
        return this;
    }
    public SearchPageObject goToSavedArticles(){
        tapElement(By.id("Saved"));
        return this;
    }
    public SearchPageObject closeWindow(){
        tapElement(By.id("Close"));
        return this;
    }
    public SearchPageObject testCheckArticle(String art,String art2){
        checkVisible(art,art2);
        return this;
    }

    public SearchPageObject longTouchOnArticle(String articleOne){
        longTouch(By.id(""+articleOne+""));
        return this;
    }
    public SearchPageObject deleteThisArticle(){
        tapElement(By.id("Remove from saved"));
        return this;
    }
}
