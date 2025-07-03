package com.hcc.hccbanking.test;

import com.hcc.hccbanking.comon.TestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestExecutionListener.class)
public class SampleTest {



    @Test
    public void testA() {
        System.out.println("Executing test A");
        // Simulate data collection
        Assert.assertTrue(true);
    }

    @Test
    public void testB() {
        System.out.println("Executing test B");
        // Simulate failure
        Assert.assertTrue(false, "Intentional failure");
    }

    @Test
    public void testC() {
        System.out.println("Executing test C");
        Assert.assertTrue(true);
    }

    @Test
    public void testD() {
        System.out.println("Executing test C");
        Assert.assertTrue(true);
    }

    @Test
    public void testE() {
        System.out.println("Executing test C");
        Assert.assertTrue(true);
    }
    @Test
    public void testF() {
        System.out.println("Executing test C");
        Assert.assertTrue(true);
    }
}
