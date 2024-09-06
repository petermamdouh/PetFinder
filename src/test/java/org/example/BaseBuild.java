package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;


public class BaseBuild extends Variables
{
    ExtentReports extent;
    protected WebDriver driver;

    @BeforeSuite
    public void  globalSetup () {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("Navigate to the PetFinder", "Navigate to PetFinder.com");

        switch ("chrome") {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-blink-features=AutomationControlled");
                options.addArguments("--disable-extensions");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }

        driver.get(site_URL);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signIN_btn)));

        test.log(Status.PASS, "Navigated Successfully");
    }

    @AfterSuite
    public void globalTearDown () {
        extent.flush();
        driver.close();
    }
}
