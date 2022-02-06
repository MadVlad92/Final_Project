package pages.Elements.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class textBox {
    Faker faker = new Faker();
    WebDriver wd;

    @FindBy(id = "userName")
    WebElement userName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;
    @FindBy(id = "submit")
    WebElement submit;
    @FindBy(xpath = "//div[@id='output']//div[1]")
    WebElement poruka;
    @FindBy(xpath = "//div[@class='text-field-container']//form[1]")
    WebElement orignal;


    public textBox(WebDriver driver) {
        this.wd = driver;
        PageFactory.initElements(driver, this);
    }

    public void textBoxForm() {
        userName.sendKeys(faker.name().fullName());
        userEmail.sendKeys(faker.internet().emailAddress());
        currentAddress.sendKeys(faker.address().fullAddress());
        permanentAddress.sendKeys(faker.address().secondaryAddress());
        submit.click();
    }


    public void CheckingForm() {
        if (userName.equals(userName)) {
            System.out.println("UserName is SAME");
        } else {
            System.out.println("UserName is NOT SAME");
            wd.close();
        }
        if (userEmail.equals(userEmail)) {
            System.out.println("eMail is SAME");
        } else {
            System.out.println("Email is NOT SAME");
            wd.close();
        }
        if (currentAddress.equals(currentAddress)) {
            System.out.println("Current Addres is SAME");
        } else {
            System.out.println("Address is NOT SAME");
            wd.close();
        }
        if (permanentAddress.equals(permanentAddress)) {
            System.out.println("Permanent address is SAME");
        } else {
            System.out.println("Permanent address is NOT SAME");
            wd.close();

        }
    }

    public String getConfLogin() {
        return poruka.getText();

    }


}