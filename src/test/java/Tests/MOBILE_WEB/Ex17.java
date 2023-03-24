package Tests.MOBILE_WEB;


import Settings.SeleniumFramework.BaseTestSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Ex17 extends BaseTestSelenium {
    public Ex17(WebDriver driver) {
        super(driver);
    }

    public Ex17 clickMenu(){
        tapElement(By.xpath("//label[@for='main-menu-input']"));
        return this;
    }
    public Ex17 clickLogIn(){
        tapElement(By.xpath("//span[@class='mw-ui-icon-minerva-logIn mw-ui-icon']"));
        return this;
    }
    public Ex17 fillLogIn(String logIn){
        fillText(By.id("wpName1"),logIn);
        return this;
    }
    public Ex17 fillPass(String pass){
        fillText(By.id("wpPassword1"), pass);
        return this;
    }
    public Ex17 pressLogIn(){
        tapElement(By.id("wpLoginAttempt"));
        return this;
    }
    public Ex17 ClickOnSearch(){
        tapElement(By.id("searchIcon"));
        return this;
    }
    public Ex17 fillTextInSearch(String text){
        fillText(By.xpath("//input[@class='search mw-ui-background-icon-search']"),text);
        return this;
    }
    public Ex17 clickOnResult(String result){
        tapElement(By.xpath("//li[@title='"+result+"']"));
        return this;
    }
    public Ex17 addInWatchList() throws InterruptedException {
        justWait();
        tapElement(By.id("ca-watch"));
        return this;
    }
    public Ex17 clickWatchList(){
        tapElement(By.xpath("//span[@class='mw-ui-icon-minerva-watchlist mw-ui-icon']"));
        return this;
    }
    public Ex17 deleteArticleFromWatchList(String article){
        tapElement(By.xpath("//li[@title='"+article+"']//a[@aria-controls='mw-watchlink-notification']"));
        return this;
    }
    public Ex17 refreshWatchPage() throws InterruptedException {
        refreshPage();
        return this;
    }
    public Ex17 checkVisible(String One, String Two){
        checkArticlesInMobileWeb(One,Two);
        return this;
    }

}
