package Tests.iOS;

import Settings.iOS.BaseIOSTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Ex12 extends BaseIOSTest {
    public Ex12(AppiumDriver driver) {
        super(driver);
    }

    public Ex12 skipFirstScreen(){
        tapElement(By.xpath("//*[@name='Skip']"));
        return this;
    }
    public Ex12 tapOnSearchLine(){
        tapElement(By.id("Search Wikipedia"));
        return this;
    }
    public Ex12 fillTextInSearchLine(String foundArticle){
        fillText(By.id("Search Wikipedia"), foundArticle);
        return this;
    }
    public Ex12 assertCountOfGetArticles(String Article){
        String xPathResult = "//*[contains(@name,'"+Article+"')]";
        setWait(By.xpath(xPathResult));
        List<MobileElement> getElement = driver.findElements(By.xpath(xPathResult));
       int x = getElement.size();
        System.out.println(x);
        for (int i = 0; i < x; i++){
            System.out.println(getElement.get(i).getText());
        }
        return this;
    }
}
