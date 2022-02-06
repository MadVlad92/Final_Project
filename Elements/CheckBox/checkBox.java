package pages.Elements.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkBox {
    Faker faker = new Faker();
    WebDriver wd;
    //WEB ELEMENTS
    @FindBy(id = "tree-node-home")
    WebElement checkBox;
    @FindBy(xpath ="//label[contains(@for,'tree-node-home')]" )
    WebElement checkBoxLabel;
    @FindBy (xpath = "//button[@class='rct-option rct-option-expand-all']")
    WebElement expandAll;
    @FindBy (xpath = "//button[@class='rct-option rct-option-collapse-all']")
    WebElement collapseAll;
    @FindBy (xpath = "(//input[@id='tree-node-home']/following-sibling::span)[3]")
    WebElement checkbox1;


    public checkBox(WebDriver driver) {
        this.wd = driver;
        PageFactory.initElements(driver, this);
    }
    public String checkBoxAndLabel(){
        System.out.println("Checkbox text: " + checkBox.getText());
        System.out.println("Label text: " + checkBoxLabel.getText());
        System.out.println("Checkbox is displayed: " + checkBox.isDisplayed());
        System.out.println("Checkbox is enabled: " + checkBox.isEnabled());
        System.out.println("Checkbox is selected: " + checkBox.isSelected());
        return checkBoxAndLabel();

    }
    public void clickExpandAll(){
        expandAll.click();


    }
    public void clickCollapseAll(){
        collapseAll.click();
    }
    public void clickCheckBox(){
checkbox1.click();
    }

}