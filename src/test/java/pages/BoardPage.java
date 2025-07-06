package pages;

import configuration.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardPage extends BasePage {

    public BoardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-cy='create-board']")
    private WebElement board;
    public WebElement getBoard() {
        return board;
    }

    @FindBy(xpath = "//*[@class='new-board-input']")
    private WebElement boardNameInputField;
    public WebElement getBoardNameInputField(){
        return boardNameInputField;
    }

    @FindBy(xpath  = "//button[@data-cy='new-board-create']")
    private WebElement boardCreateButton;
    public WebElement getBoardCreateButton(){
        return boardCreateButton;
    }


    private final By createdBoards = By.xpath("//div[@data-cy='board-item']//h2");
    public By getCreatedBoards(){
        return createdBoards;
    }
}
