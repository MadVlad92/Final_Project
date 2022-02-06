package pages.Buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PropReader;

import java.io.IOException;
import java.time.Duration;

public class testButtons {
    WebDriver wd;


    @BeforeClass
    public void init() throws IOException {
        System.setProperty("Chromedriver.chrome.driver",
                "\"D:\\QA\\SELENIUM\\chromedriver.exe\"");
        PropReader.fetchProperty("DRIVER.CHROME.PATH");

        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void closeWebDriver() {
        wd.close();
    }

    @Test
    public void Buttons() throws InterruptedException {

        System.out.println("Go to https://demoqa.com/buttons");
        wd.get("https://demoqa.com/buttons");
        wd.manage().window().maximize();
        Assert.assertEquals(wd.getCurrentUrl(), "https://demoqa.com/buttons",
                "The current url should be equal to https://demoqa.com/buttons");

        buttons buttons = new buttons(wd);

        buttons.clickDouble();
        Thread.sleep(3000);
        WebElement msg1 = wd.findElement(By.xpath("//div[contains(@class,'col-12 mt-4')]//p[1]"));
        Assert.assertEquals(msg1.getText(), "You have done a double click");
        Thread.sleep(3000);

        buttons.clickRight();
        Thread.sleep(3000);
        WebElement msg2;
        msg2 = wd.findElement(By.xpath("//p[text()='You have done a right click']"));
       Assert.assertEquals(msg2.getText(), "You have done a right click");

        buttons.clickSingle();
        Thread.sleep(3000);
        WebElement msg3 = wd.findElement(By.xpath("(//div[contains(@class,'col-12 mt-4')]//p)[3]"));
        Assert.assertEquals(msg3.getText(),"You have done a dynamic click");
        Thread.sleep(3000);


    }
}
