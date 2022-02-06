package pages.Elements.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Elements.pages.textBox;
import pages.PropReader;

import java.io.IOException;
import java.time.Duration;

public class testTextBox {
    private WebDriver wd;


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
    public void testBox() {
        System.out.println("Go to https://demoqa.com/text-box");
        wd.get("https://demoqa.com/text-box");
        wd.manage().window().maximize();

        Assert.assertEquals(wd.getCurrentUrl(), "https://demoqa.com/text-box",
                "The current url should be equal to https://demoqa.com/text-box");

        textBox elementsElements = new textBox(wd);
        elementsElements.textBoxForm();

        String poruka = elementsElements.getConfLogin();
        WebElement poruka1 = wd.findElement(By.xpath("//div[@id='output']//div[1]"));

        Assert.assertEquals(poruka, poruka1.getText(),
                "Informations are same");


    }
}