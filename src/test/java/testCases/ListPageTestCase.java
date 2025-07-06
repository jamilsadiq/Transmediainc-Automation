package testCases;

import configuration.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.ListPage;
import utilities.Variables;

import java.time.Duration;
import java.util.List;

@Epic("List Management")
@Feature("Create and Delete Lists")
public class ListPageTestCase extends BaseTest {

    static ListPage lp;
    static BoardPage bp;

    @Test(description = "Test Case: Add two lists and verify two lists created successfully. And Delete a List")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User should be able to create multiple lists and delete list")

    public void createListTestCases() throws InterruptedException {
        bp = new BoardPage(driver);
        lp = new ListPage(driver);
        clickOnBoard();
        createMultipleLists();
        deleteList();
    }

    @Step("Click on the created board")
    public void clickOnBoard() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10));
        List<WebElement> boardNames = driver.findElements(bp.getCreatedBoards());

        if (boardNames.size() > boardNames.size()+1) {
            boardNames.get(boardNames.size()+1).click();
        }
    }

    @Step("Create multiple lists using a single function")
    public void createMultipleLists() throws InterruptedException {
        createLists(Variables.LIST_1, Variables.LIST_2);
    }


    @Step("Delete the first created list")
    public void deleteList() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lp.getListOptionsButton())).click();
        wait.until(ExpectedConditions.elementToBeClickable(lp.getListDeleteButton())).click();
        Thread.sleep(1500);
        List<WebElement> listNames = driver.findElements(lp.getListInputFields());
        Assert.assertEquals(listNames.size(),1,"List not Deleted");
    }


    private void createLists(String... list) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(lp.getListNameInputField()));
        for (String name : list) {
            inputField.clear();
            inputField.sendKeys(name);
            lp.getAddListButton().click();
            Thread.sleep(1500);
        }
        List<WebElement> listNames = driver.findElements(lp.getListInputFields());
        Assert.assertEquals(listNames.get(0).getAttribute("value"),list[0],"List not created");
        Assert.assertEquals(listNames.get(1).getAttribute("value"),list[1],"List not created");
    }
}
