package com.hcc.hccbanking.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class App01 {

    @Severity(SeverityLevel.CRITICAL)
    @Description("check test data")
    @Test(groups = {"ttfb"}, description = "my test")
    public void test01(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://practicetestautomation.com/");
//        WebElement fidBy = webDriver.findElement(By.id("menu-item-43"));
        List<WebElement> webElementList = webDriver.findElements(By.tagName("button"));
        System.err.println("vfdjgdfkl;glfh+ "+ webElementList.get(0));
    }
}
