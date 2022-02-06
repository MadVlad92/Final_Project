package pages.BookStoreApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PropReader;

import java.io.IOException;
import java.time.Duration;

public class testLogin {
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
     * Put UserName and Password.
     * UserName: DaysGone92 , Password: Pass123@@
     * Click Login
     * Assert that you are logged in.
     */

    @Test(priority = 1)
    public void testLoginValid() throws InterruptedException {
        System.out.println("Go to https://demoqa.com/login");
        wd.get("https://demoqa.com/login");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://demoqa.com/login",
                "The current url should be equal to https://demoqa.com/login");

        dQAElements dQAElements = new dQAElements(wd);
        dQAElements.clickCloseAD();
        dQAElements.userNameAndPassword("DaysGone92", "Pass123@@");
        Thread.sleep(1000);
        String confirmationMsg = dQAElements.getConfLogin();
        System.out.println("Check username box on page");
        Assert.assertEquals(confirmationMsg, "DaysGone92",
                "DaysGone92");
        Thread.sleep(2000);
        dQAElements.clickLogOut();
        Thread.sleep(2000);
    }

    /**
     * Open browser and go to : https://demoqa.com/login
     * Put invalid UserName and Password.
     * UserName: DaysGone992 , Password: Pass1123@@
     * Click Login
     * Assert error message is present.
     */

    @Test(priority = 2)
    public void testLoginInvalid() throws InterruptedException {
        System.out.println("Go to https://demoqa.com/login");
        wd.get("https://demoqa.com/login");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://demoqa.com/login",
                "The current url should be equal to https://demoqa.com/login");

        dQAElements dQAElements = new dQAElements(wd);
        dQAElements.clickCloseAD();
        dQAElements.userNameAndPassword("DaysGone992", "Pass1123@@");
        String confirmationMsg = dQAElements.getErorrLogin();
        System.out.println("Check error message");
        Assert.assertEquals(confirmationMsg, "Invalid username or password!",
                "Invalid username or password!");
        Thread.sleep(2000);
    }
}
