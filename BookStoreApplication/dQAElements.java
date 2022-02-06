package pages.BookStoreApplication;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dQAElements {
    WebDriver driver;

    //TEST LOGIN
    @FindBy(xpath = "//a[@id='close-fixedban']//img[1]")
    WebElement closeAD;
    @FindBy(xpath = "(//div[@class='col-md-9 col-sm-12']//input)[1]")
    WebElement userName;
    @FindBy(xpath = "(//div[@class='col-md-9 col-sm-12']//input)[2]")
    WebElement password;
    @FindBy(xpath = "(//div[@class='text-right button']//button)[1]")
    WebElement submit;
    @FindBy(xpath = "(//div[contains(@class,'text-right col-md-5')]//label)[2]")
    WebElement confLogin;
    @FindBy(xpath = "//div[@class='col-md-12 col-sm-12']//p[1]")
    WebElement errorLogin;
    @FindBy(xpath = "(//button[@id='submit'])[1]")
    WebElement logOut;

    //TEST BOOK STORE
    @FindBy(xpath = "//div[contains(@class,'text-right col-md-4')]//button[1]")
    WebElement logInButton;
    @FindBy(xpath = "//span[@id='see-book-Learning JavaScript Design Patterns']//a[1]")
    WebElement JavaBook;
    @FindBy(xpath = "(//button[@id='addNewRecordButton'])[2]")
    WebElement addtoCollection;
    @FindBy(xpath = "html[1]")
    WebElement scrollDown;
    @FindBy(xpath = "//span[text()='Profile']")
    WebElement profile;
    @FindBy(xpath = "//span[@class='mr-2']//a[1]")
    WebElement confThatBookIsInCart;
    @FindBy(xpath = "(//div[@class='action-buttons']//span)[2]")
    WebElement trashCanIcon;
    @FindBy(xpath = "//div[@class='modal-footer']//button[1]")
    WebElement okButton;  // Conf Ok for deleting book
    @FindBy(xpath = "(//label[@class='form-label']//a[1]")
    WebElement logInProfile;
    @FindBy(xpath = "//div[contains(@class,'text-right button')]//button[1]")
    WebElement deleteAllBooks;

    public dQAElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickCloseAD() {
        closeAD.click();
    }

    public void userNameAndPassword(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        submit.click();

    }

    public void clickLogOut() {
        logOut.click();
    }

    public String getConfLogin() {
        return confLogin.getText();
    }


    public String getErorrLogin() {
        return errorLogin.getText();
    }

    public void chooseJavaBook() {
        JavaBook.click();
        addtoCollection.click();

    }

    public void BooksLoginButton(String userName, String password) {
        logInButton.click();
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        submit.click();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public void clickProfile() {
        profile.click();
    }

    public String getConfThatBookIsInCart() {
        return confThatBookIsInCart.getText();
    }


    public void deleteBookFromCart() {
        trashCanIcon.click();
        okButton.click();
    }

    public void clickDeleteAllBooks() {
        deleteAllBooks.click();
        okButton.click();
    }
}


