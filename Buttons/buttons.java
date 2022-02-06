package pages.Buttons;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class buttons {
    Faker faker = new Faker();
    WebDriver driver;


    //WEB ELEMENTS

    @FindBy(xpath = "(//div[contains(@class,'col-12 mt-4')]//button)[2]")
    WebElement doubleClick;
    @FindBy(xpath = "(//div[@class='mt-4']//button)[1]")
    WebElement rightClick;
    @FindBy(xpath = "(//div[@class='mt-4']//button)[2]")
    WebElement singleCLick;


    public buttons(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickDouble() {
        Actions action = new Actions(driver);
        action.doubleClick(doubleClick).perform();
    }

    public void clickRight() {
        Actions action = new Actions(driver);
        action.contextClick(rightClick).perform();

    }

    public void clickSingle() {
        Actions action = new Actions(driver);
        action.click(singleCLick).perform();
    }


}
