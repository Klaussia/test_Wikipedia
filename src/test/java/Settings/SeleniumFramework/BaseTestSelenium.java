package Settings.SeleniumFramework;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTestSelenium extends TestBaseSelenium {
    public BaseTestSelenium (WebDriver driver){
        this.driver = driver;
    }

    protected void setWait(By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    protected void justWait() throws InterruptedException {
        Thread.sleep(1000);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
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
    protected void refreshPage() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().refresh();
    }
    protected boolean testOne(String article){
        try {
            driver.findElement(By.xpath("//li[@title='"+article+"']"));
            return true;
        }catch (NoSuchElementException a){
            a.getCause();
            return false;
        }
    }
    protected boolean testTwo(String article){
        try {
            driver.findElement(By.xpath("//li[@title='"+article+"']"));
            return true;
        }catch (NoSuchElementException a){
            a.getCause();
            return false;
        }
    }
    protected void checkArticlesInMobileWeb(String One, String Two){
        if(testOne(One)){
            elementIsDisplayed(By.xpath("//li[@title='"+One+"']"));
            System.out.println("Visible only one article: " + One);
        }else if (testTwo(Two)) {
            elementIsDisplayed(By.xpath("//li[@title='"+Two+"']"));
            System.out.println("Visible only one article: " + Two);
        }
    }
    protected boolean elementIsDisplayed(By elementBy){
        Assertions.assertTrue(driver.findElement(elementBy).isDisplayed(), "Element not found");
        return false;
    }
}
