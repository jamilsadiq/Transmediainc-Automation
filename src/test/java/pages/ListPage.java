package pages;

import configuration.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends BasePage {
    public ListPage(WebDriver driver) {
        super(driver);
    }


    private final By listInputFields = By.xpath("//input[@data-cy='list-name']");
    public By getListInputFields() {
        return listInputFields;
    }

    private final By listNameInputField = By.xpath("//input[@data-cy='add-list-input']");
    public By getListNameInputField() {
        return listNameInputField;
    }

    @FindBy(xpath = "//button[text()='Add list']")
    private WebElement addListButton;
    public WebElement getAddListButton(){
        return addListButton;
    }

    @FindBy(xpath = "(//*[name()='svg'][@class='inline-block flex-grow-0 place-self-end p-1.5 w-8 h-8 text-gray10 bg-transparent hover:bg-gray4 active:bg-gray7 rounded-sm border-2 border-transparent cursor-pointer'])[1]")
    private WebElement listOptionsButton;
    public WebElement getListOptionsButton(){
        return listOptionsButton;
    }

    @FindBy(xpath = "(//div[@class='block py-1 px-2 pt-2 text-sm text-gray-700 hover:bg-gray1 active:bg-gray2 cursor-pointer text-red-600'])[1]")
    private WebElement listDeleteButton;
    public WebElement getListDeleteButton(){
        return listDeleteButton;
    }

}