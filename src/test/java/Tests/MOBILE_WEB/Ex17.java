package Tests.MOBILE_WEB;


import Settings.SeleniumFramework.BaseTestSelenium;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Ex17 extends BaseTestSelenium {
    public Ex17(WebDriver driver) {
        super(driver);
    }

    @Step("Кликаю на бургерное меню")
    public Ex17 clickMenu(){
        tapElement(By.xpath("//label[@for='main-menu-input']"));
        return this;
    }
    @Step("Кликаю на кнопку логина")
    public Ex17 clickLogIn(){
        tapElement(By.xpath("//span[@class='mw-ui-icon-minerva-logIn mw-ui-icon']"));
        return this;
    }
    @Step("Заполняю данные логина")
    public Ex17 fillLogIn(String logIn){
        fillText(By.id("wpName1"),logIn);
        return this;
    }
    @Step("Заполняю данные пароля")
    public Ex17 fillPass(String pass){
        fillText(By.id("wpPassword1"), pass);
        return this;
    }
    @Step("Жму кнопку Войти")
    public Ex17 pressLogIn(){
        tapElement(By.id("wpLoginAttempt"));
        return this;
    }
    @Step("Нажимаю на иконку поиска")
    public Ex17 ClickOnSearch(){
        tapElement(By.id("searchIcon"));
        return this;
    }
    @Step("Заполняю данные для поиска")
    public Ex17 fillTextInSearch(String text){
        fillText(By.xpath("//input[@class='search mw-ui-background-icon-search']"),text);
        return this;
    }
    @Step("Кликаю на интересующий меня результат")
    public Ex17 clickOnResult(String result){
        tapElement(By.xpath("//li[@title='"+result+"']"));
        return this;
    }
    @Step("Добавляю статью в Избранное")
    public Ex17 addInWatchList() throws InterruptedException {
        justWait();
        tapElement(By.id("ca-watch"));
        return this;
    }
    @Step("Кликаю на Избранное")
    public Ex17 clickWatchList(){
        tapElement(By.xpath("//span[@class='mw-ui-icon-minerva-watchlist mw-ui-icon']"));
        return this;
    }
    @Step("Удаляю одну из выбранных статей")
    public Ex17 deleteArticleFromWatchList(String article){
        tapElement(By.xpath("//li[@title='"+article+"']//a[@aria-controls='mw-watchlink-notification']"));
        return this;
    }
    @Step("Обновляю страницу")
    public Ex17 refreshWatchPage() throws InterruptedException {
        refreshPage();
        return this;
    }
    @Step("Проверяю какая из статей сейчас отображается на странице")
    public Ex17 checkVisible(String One, String Two){
        checkArticlesInMobileWeb(One,Two);
        return this;
    }

}
