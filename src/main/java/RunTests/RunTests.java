package RunTests;

import Settings.TestBase;
import Tests.Ex3;
import Tests.Ex5;
import Tests.Ex6;
import org.junit.jupiter.api.Test;

public class RunTests extends TestBase {
    @Test
    public void startEx3(){
        Ex3 ex3 = new Ex3(driver);
        ex3.clickOnSearchLine()
                .fillTextInSearchLine("Java")
                .hideKeyboard()
                .assertCountedElementsOnPage()
                .clearSearch()
                .assertSearchResultMissing();
    }

    @Test
    public void startEx5(){
        String firstArticle = "Coffee Lake";
        String secondArticle = "Milky Way";
        Ex5 ex5 = new Ex5(driver);
        ex5
                .clickSearchInput()
                .fillSearchNews(firstArticle)
                .chooseFirstArticle(firstArticle)
                .openMoreOptions()
                .addToReadingList()
                .pressButtonGotIt()
                .clearEntry()
                .fillNewName("Reading List")
                .pressOk()
                .closeNews()
                .clickSearchInput()
                .fillSearchNews(secondArticle)
                .chooseSecondArticle(secondArticle)
                .openMoreOptions()
                .addToReadingList()
                .clickOnCreatedReadingList()
                .clickViewList()
                .assertReadingListWithTwoNews()
                .longPressOnArticle(secondArticle)
                .clickOnBasket()
                .assertReadingListWithOneNews()
                .clickOnArticle(firstArticle)
                .assertArticleTitle(firstArticle);
    }
    @Test
    public void startEx6(){
        String text = "Java";
        Ex6 ex6 = new Ex6(driver);
        ex6
                .clickSearchInput()
                .fillSearchNews(text)
                .hideKeyboard()
                .chooseFirstArticle(text)
                .assertElementPresent();
    }
}
