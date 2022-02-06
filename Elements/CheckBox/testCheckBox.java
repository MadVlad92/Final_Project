package pages.Elements.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Elements.pages.checkBox;
import pages.PropReader;

import java.io.IOException;
import java.time.Duration;

public class testCheckBox {
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
    public void checkBox() throws InterruptedException {

        System.out.println("Go to https://demoqa.com/checkbox");
        wd.get("https://demoqa.com/checkbox");
        wd.manage().window().maximize();
        Assert.assertEquals(wd.getCurrentUrl(), "https://demoqa.com/checkbox",
                "The current url should be equal to https://demoqa.com/checkbox");

        checkBox checkBox = new checkBox(wd);

        WebElement checkBox1 = wd.findElement(By.id("tree-node-home"));
        WebElement checkBoxLabel = wd.findElement(By.xpath("//label[contains(@for,'tree-node-home')]"));
        System.out.println("Checkbox text: " + checkBox1.getText());
        System.out.println("Label text: " + checkBoxLabel.getText());
        System.out.println("Checkbox is displayed: " + checkBox1.isDisplayed());
        System.out.println("Checkbox is enabled: " + checkBox1.isEnabled());
        System.out.println("Checkbox is selected: " + checkBox1.isSelected());
        checkBox.clickCheckBox();
        System.out.println("Checkbox is selected: " + checkBox1.isSelected());

        Thread.sleep(1000);
        checkBox.clickExpandAll();
        Thread.sleep(2000);
        checkBox.clickCollapseAll();
        WebElement msg = wd.findElement(By.xpath("//div[@id='result']//span[1]"));
        Assert.assertEquals(msg.getText(), "You have selected :");


    }
}

