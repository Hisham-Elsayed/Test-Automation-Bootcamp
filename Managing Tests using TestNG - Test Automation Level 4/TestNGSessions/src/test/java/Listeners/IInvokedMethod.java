package Listeners;

import org.testng.ITestResult;

public class IInvokedMethod implements org.testng.IInvokedMethodListener{

    public void beforeInvocation(org.testng.IInvokedMethod method, ITestResult testResult) {
        System.out.println(method.getTestMethod().getMethodName());
    }

    public void afterInvocation(org.testng.IInvokedMethod method, ITestResult testResult) {
        System.out.println(testResult.getStatus());
    }
}
