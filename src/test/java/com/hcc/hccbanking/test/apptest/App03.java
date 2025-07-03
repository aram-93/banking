package com.hcc.hccbanking.test.apptest;

import com.hcc.hccbanking.comon.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class App03 extends BaseTest {


    @DataProvider(name = "testData")
    public Object[][] testDataProvider() {
        return new Object[][] {
                {"Data for test 1"},
                {"Data for test 2"}
        };
    }

    @Test(dataProvider = "testData",dependsOnMethods = {"testMethod01"})
    @Severity(SeverityLevel.BLOCKER)
    @Description("check test data")
    public void testMethod(String data) {
        System.out.println("Test method received data: " + data);
        System.out.println("Shared data: " + sharedData);
        System.out.println("device test.App03: " + device);
    }
    @Test()
    @Severity(SeverityLevel.CRITICAL)
    @Description("check test data")
    public void testMethod01() {
        System.out.println("Test method received data: " + "001");
        System.out.println("Shared data: " + sharedData);
        System.out.println("device test.App03: " + device);
    }

    @Test(dependsOnMethods = {"testMethod01"})
    @Severity(SeverityLevel.TRIVIAL)
    @Description("check test data")
    public void testMethod02() {
        System.out.println("Test method received data: " + "001");
        System.out.println("Shared data: " + sharedData);
        System.out.println("device test.App03: " + device);
    }

}