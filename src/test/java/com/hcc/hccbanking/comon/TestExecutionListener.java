package com.hcc.hccbanking.comon;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.HashMap;
import java.util.Map;

public class TestExecutionListener implements IInvokedMethodListener {

    private static final Map<String, Object> dataCollection = new HashMap<>();

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // Before each method runs
        if (method.isTestMethod()) {
            System.out.println("Starting test: " + method.getTestMethod().getMethodName());
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // After each method runs
        if (method.isTestMethod()) {
            // Collect data in the middle of the test suite
            String testName = method.getTestMethod().getMethodName();
            dataCollection.put(testName, testResult.getStatus());

            // Perform action based on data collected
            if (dataCollection.containsValue(ITestResult.FAILURE)) {
                System.out.println("Detected failure in test: " + testName + " - performing action...");
                // Insert any custom action like taking a screenshot, logging, etc.
            }
        }
    }
}

// Test Class Example

