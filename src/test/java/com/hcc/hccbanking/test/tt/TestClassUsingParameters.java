package com.hcc.hccbanking.test.tt;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestClassUsingParameters {

    @Test(groups = {"ttfb"}, description = "my test description", dataProvider = "dp")
    public void testMethod() {
        String name = "jskfhhTest";
        int age = 20;
        HashMap hashMap = new HashMap();
        hashMap.put("name", name);
        hashMap.put("age", age);



        Assert.assertNotEquals(age,1);
    }
}
