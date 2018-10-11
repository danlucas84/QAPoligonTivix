import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// test check if homePage function -(cliking on Tivix logo) working correctly


// because of lack of time there is no page object pattern and inside the test there is thread.sleep().

// Finally should be implemented Page object pattern (model) to not duplicate code and fluent wait /implicit wait insted of thread.sleep()


public class HomeButtonFunctionTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test

    public void Checking_If_User_Can_Move_To_HomePage_Cliking_TivixLogo() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

        driver.manage().timeouts().setScriptTimeout(35, TimeUnit.SECONDS);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // user go to site and see main page
        driver.navigate().to("https://www.tivix.com/");
        // user clicking contacts
        driver.findElement(By.xpath("(//*[@id=\"__next\"]//span)[8]")).click();

        // user clicking cookies info

        driver.findElement(By.cssSelector("body >.cc-type-info> div > a")).click();


        // clicking case studies section
        driver.findElement(By.xpath("(//span[text()='case studies'])[1]")).click();



        //scroll down in section conctracts

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");


            //Scroll up in section case studies

        js.executeScript("window.scrollBy(0,-250)", "");


            // after clicking case studies user click to Tivix logo to back to main site
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.findElement(By.cssSelector("#__next > div  div.hero-height > div:nth-child(1) > div.nav-absolute > a > img")).click();
        //Assert.assertTrue(driver.findElement(By.cssSelector(".hero-height > div:nth-child(1) > div.nav-absolute > a > img")).isSelected());
        driver.findElement(By.xpath("(//*[@id=\"__next\"]//div[1]/div[1]//a//img)[1]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id=\"__next\"]//div[1]/div[1]//a//img)[1]")).isSelected());


        }

        @AfterMethod
        public void afterTest() {
            driver.close();
            driver.quit();
        }
    }


