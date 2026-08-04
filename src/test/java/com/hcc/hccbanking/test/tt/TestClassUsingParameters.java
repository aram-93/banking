package com.hcc.hccbanking.test.tt;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class TestClassUsingParameters {

    @Test(groups = {"ttfb"}, description = "my test description")
    public void testMethod() {
        SoftAssert softAssert = new SoftAssert();
        String name = "jskfhhTest";
        int age = 20;
        HashMap hashMap = new HashMap();
        hashMap.put("name", name);
        hashMap.put("age", age);



        softAssert.assertNotEquals(age,1);
        softAssert.assertAll();
    }
}
