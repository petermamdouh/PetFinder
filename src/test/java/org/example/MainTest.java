package org.example;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class MainTest extends  BaseBuild{

    @Test(priority = 0)
    public void Registration() throws IOException, ParseException {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.getDataFile();

        ExtentTest test  = extent.createTest("Register & Login", "JSON data implemented - customer details");

        WebElement SignIN_BTN = driver.findElement(By.xpath(signIN_btn));
        SignIN_BTN.click();

        WebElement CreateAccount_BTN = driver.findElement(By.xpath(createAccount_BTN));
        CreateAccount_BTN.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(continue_BTN)));

        WebElement Email_field = driver.findElement(By.xpath(email_field));
        Email_field.sendKeys(jsonReader.email);

        WebElement Continue_BTN = driver.findElement(By.xpath(continue_BTN));
        Continue_BTN.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(frName_field)));

        WebElement FirstName_field = driver.findElement(By.xpath(frName_field));
        FirstName_field.sendKeys(jsonReader.fristname);

        WebElement LastName_field = driver.findElement(By.xpath(lastName_field));
        LastName_field.sendKeys(jsonReader.lastname);

        WebElement PostalCode_field = driver.findElement(By.xpath(ZIPcode_field));
        PostalCode_field.sendKeys("12215");

        Select dogCount_DDL = new Select(driver.findElement(By.xpath(dogcount_Dropdown)));
        dogCount_DDL.selectByValue("1");

        Select catCount_DDL = new Select(driver.findElement(By.xpath(catcount_Dropdown)));
        catCount_DDL.selectByValue("0");

        if(!driver.findElements(By.xpath(exitCookies)).isEmpty()){

            WebElement closeCookies = driver.findElement(By.xpath(exitCookies));
            closeCookies.click();

            WebElement Continue2_BTN = driver.findElement(By.xpath(continue_BTN2));
            Continue2_BTN.click();

        }else{
            WebElement Continue2_BTN = driver.findElement(By.xpath(continue_BTN2));
            Continue2_BTN.click();
        }

        WebElement Continue2_BTN = driver.findElement(By.xpath(continue_BTN2));
        Continue2_BTN.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pass_field)));

        WebElement password_field = driver.findElement(By.xpath(pass_field));
        password_field.sendKeys("Peter@123");

        WebElement conf_password_field = driver.findElement(By.xpath(confirm_pass_field));
        conf_password_field.sendKeys("Peter@123");

        WebElement checkBox = driver.findElement(By.xpath(check_box));
        checkBox.click();

        WebElement create_account_BTN = driver.findElement(By.xpath(create_BTN));
        create_account_BTN.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verify_BTN)));

        WebElement verifyNow_BTN = driver.findElement(By.xpath(verify_BTN));
        verifyNow_BTN.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userName_field)));

        WebElement userEmail = driver.findElement(By.xpath(userName_field));
        userEmail.sendKeys(jsonReader.email);

        WebElement userPass = driver.findElement(By.xpath(userpass_field));
        userPass.sendKeys("Peter@123");

        WebElement signin = driver.findElement(By.xpath(signIN));
        signin.click();

        WebElement signup = driver.findElement(By.xpath(signUP));
        signup.click();

        test.log(Status.PASS, "User created Successfully");
    }
}
