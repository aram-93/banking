package com.hcc.hccbanking.test.apptest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class AppbTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("check test data")
    @Test(groups="gpOne")
    public void testOne() {
        System.out.println("The test belongs to Group One");
    }
    @Test(groups="gpOne")
    @Severity(SeverityLevel.CRITICAL)
    @Description("check test data")
    public void testOne1() {
        System.out.println(1+"The test belongs to Group One" + 1);
    }
    @Test(groups="gpTwo")
    @Severity(SeverityLevel.CRITICAL)
    @Description("check test data")
    public void testTwo() {
        System.out.println(2+"The test belongs to Group Two");
    }

    @Test(groups="gpOne")
    @Severity(SeverityLevel.CRITICAL)
    @Description("check test data")
    public void testThree() {
        System.out.println(3+"The test belongs to Group One");
    }

    @Test(groups="gpTwo")
    @Severity(SeverityLevel.CRITICAL)
    @Description("check test data")
    public void testFour() {
        System.out.println(4+"The test belongs to Group Two");
    }

    @Test(groups="gpTwo")
    @Severity(SeverityLevel.CRITICAL)
    @Description("check test data")
    public void testFour4() {
        System.out.println(5+"The test belongs to Group Two" + 4);
    }

    @Test(groups={"gpOne","gpTwo"})
    @Severity(SeverityLevel.MINOR)
    @Description("check test data")
    public void testFive() {
        System.out.println(6+"The test belongs to Group One as well as Group Two");
    }

    @Test(groups={"gpThree"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("check test data")
    public void test7() {
        System.out.println(7+"The test belongs to Group One as well as Group Two");
    }
}
