package com.hcc.hccbanking.comon;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Objects;

public class BaseTest {
    // Static variable to hold data across tests
    public static String sharedData;
    public String device = "120";

    public String param;

    @Parameters("parameter")
    @BeforeMethod
    public void setup(@Optional("10") String param) {
        if (Objects.equals(param, "")){
           param="10";
        }
        sharedData = "Initial data";
        getLog(device);
        System.out.println("Setting up initial data: " + sharedData);
    }

    @AfterMethod
    public void tearDown() {
        sharedData = null;
        System.out.println("Cleaning up data.");
    }


    public void setParam(String parameter) {
        param = getParam(parameter);
        System.err.println(parameter);
    }

    public String getParam(String param) {
        return param;
    }


    public void getLog(String device) {
        System.out.println(device);
    }
}
