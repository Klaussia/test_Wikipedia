package Runners;
import Settings.SeleniumFramework.TestBaseSelenium;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Тесты на добавление статей в Избранное")
public class RunMobileWeb extends TestBaseSelenium {

    /** bauss22 | 123456aA! */

    String logIn = "bauss22";
    String password = "123456aA!";
    String resultOne = "JavaScript";
    String resultTwo = "Milky Way";
    @Test
    @Features(value = {@Feature(value = "Поиск"), @Feature(value = "Статьи")})
    @DisplayName("Тест на сохранение двух статей")
    @Description("Осуществляется поиск и добавление двух статей в избранное, затем удаляем одну из них и проверяем какая статья осталась в списке")
    @Severity(value = SeverityLevel.BLOCKER)
    public void start() throws InterruptedException {
        ex17
                .clickMenu()
                .clickLogIn()
                .fillLogIn(logIn)
                .fillPass(password)
                .pressLogIn()
                .ClickOnSearch()
                .fillTextInSearch(resultOne)
                .clickOnResult(resultOne)
                .addInWatchList()
                .ClickOnSearch()
                .fillTextInSearch(resultTwo)
                .clickOnResult(resultTwo)
                .addInWatchList()
                .clickMenu()
                .clickWatchList()
                .deleteArticleFromWatchList(resultOne)
                .refreshWatchPage()
                .checkVisible(resultOne,resultTwo)
                .deleteArticleFromWatchList(resultTwo);
    }
}
