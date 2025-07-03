package com.hcc.hccbanking.test;

import comon.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class App00 extends BaseTest {

    String parameter;

    @DataProvider(name = "testData")
    public Object[][] testDataProvider() {
        return new Object[][]{
                {"Data for test 1"},
                {"Data for test 2"}
        };
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("check test data")
    @Test(dataProvider = "testData")
    public void testMethod(String data) {
        System.err.println(param);
        device = "00000222";
        System.out.println("Test method received data: " + data);
        System.out.println("Shared data: " + BaseTest.sharedData);
        System.out.println("device test.App00: " + device);
    }


    @Test()
    @Severity(SeverityLevel.CRITICAL)
    @Description("check test data")
    public void testMethod01() {
        device = "000003547";
        System.out.println("device test.App00 " + device);
        System.out.println("Shared data: " + BaseTest.sharedData);
    }
}
