package pages.BookStoreApplication;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PropReader;

import java.io.IOException;
import java.time.Duration;

public class testBookStore {
    private WebDriver wd;

    @BeforeClass
    public void init() throws IOException {
        System.setProperty("Chromedriver.chrome.driver",
                "\"D:\\QA\\SELENIUM\\chromedriver.exe\"");
        PropReader.fetchProperty("DRIVER.CHROME.PATH");

        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void closeWebDriver() {
        wd.close();


    }

    /**
     * Open browser and go to : https://demoqa.com/login
     * Choose Learning JavaScript Design book
     * Click on : Add to your collection
     * In top of page message will appear, click : OK
     * Go to Profile
     * Assert that the book is in cart
     */

    @Test(priority = 1)
    public void testAddBook() throws InterruptedException {
        System.out.println("Go to https://demoqa.com/books");
        wd.get("https://demoqa.com/books");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://demoqa.com/books",
                "The current url should be equal to https://demoqa.com/books");
        dQAElements dQAElements = new dQAElements(wd);
        dQAElements.clickCloseAD();
        dQAElements.BooksLoginButton("DaysGone92", "Pass123@@");
        dQAElements.chooseJavaBook();
        Thread.sleep(2000);
        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        alert.accept();
        Thread.sleep(2000);
        dQAElements.scrollDown();
        Thread.sleep(2000);
        dQAElements.clickProfile();
        String confirmationMsg = dQAElements.getConfThatBookIsInCart();
        System.out.println("Check if book is in shopping cart.");
        Assert.assertEquals(confirmationMsg, "Learning JavaScript Design Patterns",
                "Learning JavaScript Design Patterns");


    }

    /**
     * Open browser and go to : https://demoqa.com/profile
     * Click trash can icon
     * Click on OK button.
     * Assert confirmation message that the book is deleted from
     * cart
     */

    @Test(priority = 2)
    public void testADeleteBook() {
        System.out.println("Go to https://demoqa.com/profile");
        wd.get("https://demoqa.com/profile");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://demoqa.com/profile",
                "The current url should be equal to https://demoqa.com/profile");
        dQAElements dQAElements = new dQAElements(wd);


        dQAElements.deleteBookFromCart();
        System.out.println("Check if book is in shopping cart.");
        Assert.assertEquals("Shopping cart is empty",
                "Shopping cart is empty");


    }

    /**
     * Open browser and go to : https://demoqa.com/books
     * Choose Learning JavaScript Design book
     * Click on : Add to your collection
     * In top of page message will appear, click : OK
     * Go to Books.
     * Click on: Delete All Books
     * Click : OK
     * Assert confirmation message that the books are deleted from
     * cart
     */

    @Test(priority = 3)
    public void testDeleteALlBooks() throws InterruptedException {
        System.out.println("Go to https://demoqa.com/books");
        wd.get("https://demoqa.com/books");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://demoqa.com/books",
                "The current url should be equal to https://demoqa.com/books");

        dQAElements dQAElements = new dQAElements(wd);


        dQAElements.chooseJavaBook();
        Thread.sleep(2000);
        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        alert.accept();
        Thread.sleep(2000);
        dQAElements.scrollDown();
        Thread.sleep(2000);
        dQAElements.clickProfile();
        dQAElements.clickDeleteAllBooks();
        Alert alert1 = new WebDriverWait(wd, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        alert1.accept();
        System.out.println("Check if book is in shopping cart.");
        Assert.assertEquals("Shopping cart is empty",
                "Shopping cart is empty");


    }
}
