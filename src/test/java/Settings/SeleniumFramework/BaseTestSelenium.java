package Settings.SeleniumFramework;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTestSelenium extends TestBaseSelenium {
    public BaseTestSelenium (WebDriver driver){
        this.driver = driver;
    }

    @Step("Ожидаю элемент")
    protected void setWait(By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    @Step("Просто жду")
    protected void justWait() throws InterruptedException {
        Thread.sleep(1000);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
    }
    @Step("Тапаю на элемент")
    protected void tapElement(By elementBy){
        setWait(elementBy);
        driver.findElement(elementBy).click();
        screen(this.takeScreenShot("scr"));
    }
    @Step("Заполняю текст")
    protected void fillText(By elementBy, String text){
        setWait(elementBy);
        driver.findElement(elementBy).sendKeys(text);
        screen(this.takeScreenShot("scr"));
    }
    @Step("Очищаю поле ввода")
    protected void clearEntryField(By elementBy){
        setWait(elementBy);
        driver.findElement(elementBy).clear();
    }
    @Step("Проверяю отображается ли элемент на странице")
    protected void elementVisible(By elementBy){
        setWait(elementBy);
        driver.findElement(elementBy).isDisplayed();
    }
    @Step("Обновление страницы")
    protected void refreshPage() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().refresh();
    }
    @Step("Смотрю присутствует ли данный элемент на странице")
    protected boolean testOne(String article){
        try {
            driver.findElement(By.xpath("//li[@title='"+article+"']"));
            return true;
        }catch (NoSuchElementException a){
            a.getCause();
            return false;
        }
    }
    @Step("Смотрю присутствует ли данный элемент на странице")
    protected boolean testTwo(String article){
        try {
            driver.findElement(By.xpath("//li[@title='"+article+"']"));
            return true;
        }catch (NoSuchElementException a){
            a.getCause();
            return false;
        }
    }
    @Step("Тут проверяем какая статья присутствует на странице и выдает ее в консоль")
    protected void checkArticlesInMobileWeb(String One, String Two){
        if(testOne(One)){
            elementIsDisplayed(By.xpath("//li[@title='"+One+"']"));
            System.out.println("Visible only one article: " + One);
        }else if (testTwo(Two)) {
            elementIsDisplayed(By.xpath("//li[@title='"+Two+"']"));
            System.out.println("Visible only one article: " + Two);
        }
    }
    @Step("Проверяю отображается ли элемент на странице")
    protected boolean elementIsDisplayed(By elementBy){
        Assertions.assertTrue(driver.findElement(elementBy).isDisplayed(), "Element not found");
        return false;
    }
    public String takeScreenShot(String name){
        TakesScreenshot ts = (TakesScreenshot)this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/" + name + "_screenshot.jpg";
        try {
            FileUtils.copyFile(source, new File(path));
            System.out.println("The screen was taken: " + path);
        }catch (Exception e){
            e.printStackTrace();
        }
        return path;
    }
    @Attachment
    public static byte[] screen(String path){
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        }catch (IOException e){
            e.printStackTrace();
        }
        return bytes;
    }
}
