package Tests;

import Settings.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Ex3 extends BaseTest {
    public Ex3(AndroidDriver driver) {
        super(driver);
    }
    public Ex3 clickOnSearchLine(){
        tapElement(By.id("org.wikipedia:id/search_container"));
        return this;
    }
    public Ex3 fillTextInSearchLine(String text){
        fillText(By.id("org.wikipedia:id/search_src_text"), text);
        return this;
    }
    public Ex3 hideKeyboard(){
        driver.hideKeyboard();
        return this;
    }
    public Ex3 assertCountedElementsOnPage(){
        assertCountElementsOnPage(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']"));
        return this;
    }
    public Ex3 clearSearch(){
        tapElement(By.id("org.wikipedia:id/search_close_btn"));
        return this;
    }
    public Ex3 assertSearchResultMissing(){
        assertSearchResultIsMissing(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']"));
        return this;
    }
}
