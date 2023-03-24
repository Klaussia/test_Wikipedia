package Runners;

import Settings.CrossPlatformClasses.TestBase;
import Tests.iOS.Ex12;
import Tests.iOS.SearchPageObject;
import Tests.iOS.iOSFirstTestAndroid;
import org.junit.jupiter.api.Test;

public class RunIOSTest extends TestBase {

    @Test
    public void start() {
        iOSFirstTestAndroid ft = new iOSFirstTestAndroid(driver);
        ft
                .clickNextButton()
                .clickButtonGetStarted()
                .assertLogotypeIsVisible();
    }
    @Test
    public void startSearchPageObject() {
        String articleOne = "JavaScript";
        String articleTwo = "Milky Way";
        SearchPageObject sp = new SearchPageObject(driver);
        sp.skipStartScreen()
                .tapOnSearchLine()
                .fillTextInSearchLine(articleOne)
                .chooseResult(articleOne)
                .saveArticle()
                .backInSearch()
                .clearText()
                .fillTextInSearchLine(articleTwo)
                .chooseResult(articleTwo)
                .saveArticle()
                .pressButtonW()
                .goToSavedArticles()
                .closeWindow()
                .longTouchOnArticle(articleOne)
                .deleteThisArticle()
                .testCheckArticle(articleOne,articleTwo);
    }
//    @Test
//    public void startEx12 (){
//        /** Инициализация iOS драйвера, при запуске всех тестов -> закоментить */
//        driver = initializeIOSDriver();
//        String result = "Java";
//        Ex12 ex12 = new Ex12(driver);
//        ex12.skipFirstScreen().tapOnSearchLine().fillTextInSearchLine(result).assertCountOfGetArticles(result);
//    }
}
