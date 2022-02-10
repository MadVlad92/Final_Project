package pages.Elements.RadioButton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class radioButton {
    WebDriver driver;


    @FindBy(xpath = "(//div[contains(@class,'custom-control custom-radio')]//label)[1]")
    WebElement yesButton;
    @FindBy(xpath = "(//div[contains(@class,'custom-control custom-radio')]//label)[2]")
    WebElement ImpressiveButton;
    @FindBy(xpath = "//div[contains(@class,'custom-control disabled')]//label[1]")
    WebElement disabledButton;
    @FindBy(className = "text-success")
    WebElement msgYes;
    @FindBy(xpath = "//span[text()='Impressive']")
    WebElement msgImpr;


    public radioButton(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickYesButton() {
        boolean selectYes = yesButton.isSelected();
        if (selectYes == false) {
            yesButton.click();
        }

    }

    public String confYesMessage() {
        return msgYes.getText();
    }

    public String ConfImprMessage() {
        return msgImpr.getText();
    }

    public void clickImpressiveButton()  {
        boolean selectImpr = ImpressiveButton.isSelected();
        if (selectImpr == false) {
            ImpressiveButton.click();
        }

    }

}
