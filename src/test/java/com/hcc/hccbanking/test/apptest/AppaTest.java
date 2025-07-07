package com.hcc.hccbanking.test.apptest;

import com.hcc.hccbanking.comon.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AppaTest extends BaseTest {

    String parameter;

    @DataProvider(name = "testData")
    public Object[][] testDataProvider() {
        return new Object[][]{
                {"Data for test 1"},
                {"Data for test 2"}
        };
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description(useJavaDoc = true)
    @AllureId("123")
    @Test(dataProvider = "testData")
    public void testMethod(String data) throws IOException {
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
