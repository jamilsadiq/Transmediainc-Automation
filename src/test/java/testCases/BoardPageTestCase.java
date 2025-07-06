package testCases;

import configuration.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.Keys;
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

@Epic("Board Management")
@Feature("Board Creation")
public class BoardPageTestCase extends BaseTest {

    static BoardPage bp;
    static ListPage lp;

    @Test(description = "Test Case: Input a Board name, press enter. Verify Board created successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User should be able to create a board")


    public void createBoardTestCase() throws InterruptedException {
        bp = new BoardPage(driver);
        lp = new ListPage(driver);
        createBoard();
        verifyBoardCreation();
    }

    @Step("Create board with predefined name")
    public void createBoard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bp.getBoard())).click();
        WebElement inputField = wait.until(ExpectedConditions.visibilityOf(bp.getBoardNameInputField()));
        inputField.clear();
        inputField.sendKeys(Variables.BOARD_NAME + Keys.ENTER);
    }

    @Step("Verify board creation by matching created board name")
    public void verifyBoardCreation() throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> boardNames = driver.findElements(bp.getCreatedBoards());
        if (boardNames.size() > 2) {
            String boardName = boardNames.get(2).getText().trim();
            Assert.assertEquals(boardName, Variables.BOARD_NAME, "Board not created!");
        }
    }
}
