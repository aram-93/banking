package com.hcc.hccbanking.test.apptest;

import com.hcc.hccbanking.comon.TestExecutionListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(TestExecutionListener.class)
public class SampleTest {



    @Test
    public void testA() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Executing test A");
        // Simulate data collection
        softAssert.assertTrue(true);
        softAssert.assertAll();
    }

    @Test
    public void testB() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Executing test B");
        // Simulate failure
        softAssert.assertTrue(false, "Intentional failure");
        softAssert.assertAll();
    }

    @Test
    public void testC() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Executing test C");
        softAssert.assertTrue(true);
        softAssert.assertAll();
    }

    @Test
    public void testD() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Executing test C");
        softAssert.assertTrue(true);
        softAssert.assertAll();
    }

    @Test
    public void testE() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Executing test C");
        softAssert.assertTrue(true);
        softAssert.assertAll();
    }
    @Test
    public void testF() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Executing test C");
        softAssert.assertTrue(true);
        softAssert.assertAll();
    }
}
