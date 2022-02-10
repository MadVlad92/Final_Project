package pages.Elements.RadioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PropReader;

import java.io.IOException;
import java.time.Duration;

public class testRadioButton {
    WebDriver wd;


    @BeforeClass
    public void init() throws IOException {
        System.setProperty("Chromedriver.chrome.driver",
                "\"D:\\QA\\SELENIUM\\chromedriver.exe\"");
        PropReader.fetchProperty("DRIVER.CHROME.PATH");

        wd = new ChromeDriver();
        wd.manage().window().maximize();

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
@AfterSuite
    public void CloseDriver(){
        wd.close();
    }

    @Test
    public void YesButton() throws InterruptedException {

        System.out.println("Go to https://demoqa.com/radio-button");
        wd.get("https://demoqa.com/radio-button");
        Assert.assertEquals(wd.getCurrentUrl(), "https://demoqa.com/radio-button",
                "The current url should be equal to https://demoqa.com/radio-button");

        radioButton radioButton = new radioButton(wd);

        radioButton.clickYesButton();
        String confMsg = radioButton.confYesMessage();
        Assert.assertEquals("You have selected:" + confMsg, "You have selected:Yes");
        Thread.sleep(2000);

        radioButton.clickImpressiveButton();
        String confMsg1 = radioButton.ConfImprMessage();
        Assert.assertEquals("You have selected:" + confMsg1, "You have selected:Impressive");
        Thread.sleep(2000);

        boolean disabledButton = wd.findElement(By.xpath("//div[contains(@class,'custom-control disabled')]//label[1]")).isSelected();
        Assert.assertEquals(disabledButton,false);







    }
}