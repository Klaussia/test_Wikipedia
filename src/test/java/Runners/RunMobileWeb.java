package Runners;
import Settings.SeleniumFramework.TestBaseSelenium;
import org.junit.jupiter.api.Test;

public class RunMobileWeb extends TestBaseSelenium {

    /** bauss22 | 123456aA! */

    String logIn = "bauss22";
    String password = "123456aA!";
    String resultOne = "JavaScript";
    String resultTwo = "Milky Way";
    @Test
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
