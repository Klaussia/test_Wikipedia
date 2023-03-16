package Tests.Android;

import Settings.Android.Android_BaseTest;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class Ex6 extends Android_BaseTest {
    public Ex6(AppiumDriver driver) {
        super(driver);
    }

    public Ex6 clickSearchInput(){
        tapElement(By.id("org.wikipedia:id/search_container"));
        return this;
    }
    public Ex6 fillSearchNews(String text){
        fillText(By.id("org.wikipedia:id/search_src_text"), text);
        return this;
    }
    public Ex6 chooseFirstArticle(String text){
        tapElement(By.xpath("//android.widget.TextView[@text='"+ text +"']"));
        return this;
    }
    public Ex6 assertElementPresent(){
        Assertions.assertTrue(driver.findElement(By.id("org.wikipedia:id/view_page_title_text")).isDisplayed(), "Title not found");
        return this;
    }
    public Ex6 hideKeyboard(){
        driver.hideKeyboard();
        return this;
    }
}
