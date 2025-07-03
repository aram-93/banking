package com.hcc.hccbanking.test.tt;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClassUsingDataProvider {

    @Test(groups = {"ttfb"}, dataProvider = "dpp")
    @Description("my test description value")
    public void testMethod(String name, int age) {

        Assert.assertNotNull(name);
        Assert.assertNotEquals(age,18);
    }

    @DataProvider(name = "dpp")
    public Object[][] getData() {
        return new Object[][]{
                {"Jack Daniels", 10},
                {"Napolean", 15}
        };
    }
}
