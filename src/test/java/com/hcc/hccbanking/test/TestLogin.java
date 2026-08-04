package com.hcc.hccbanking.test;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Epic("Login")
@Feature("Valid Login")
public class TestLogin {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login with valid credentials")
    public void testLogin() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");


        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        String actualURL = driver.getCurrentUrl();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        softAssert.assertEquals(actualURL, expectedURL);

        String expectedMessage = "Congratulations student. You successfully logged in!";

        String pageSource = driver.getPageSource();

        assert pageSource != null;
        softAssert.assertTrue(pageSource.contains(expectedMessage));

        WebElement logout = driver.findElement(By.linkText("Log out"));
        softAssert.assertTrue(logout.isDisplayed());

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login with valid credentials")
    public void incorrectPassword() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Passworrrrd123");


        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        String errorMessage = "Your password is invalid!";
        String source = driver.getPageSource();

        assert source != null;
        softAssert.assertTrue(source.contains(errorMessage));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        driver.quit();
        softAssert.assertAll();

    }
}
