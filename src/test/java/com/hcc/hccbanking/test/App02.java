package com.hcc.hccbanking.test;

import comon.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class App02 extends BaseTest {

    @DataProvider(name = "testData")
    public Object[][] testDataProvider() {
        return new Object[][] {
                {"Data for test 1"},
                {"Data for test 2"}
        };
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("check test data")
    @Test(dataProvider = "testData")
    public void testMethod(String data) {

        System.out.println("Test method received data: " + data);
        System.out.println("Shared data: " + sharedData);
        System.out.println("device test.App02: " + device);
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("check test data")
    @Test()
    public void testMethod01() {
        System.out.println("Test method received data: " + "001");
        System.out.println("Shared data: " + sharedData);
    }
}
