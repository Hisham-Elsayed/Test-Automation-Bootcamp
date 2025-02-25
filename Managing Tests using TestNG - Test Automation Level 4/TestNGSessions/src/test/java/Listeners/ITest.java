package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ITest implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println(result.getTestName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Congrats");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Failed");
    }

    public void onStart(ITestContext context) {
        System.out.println(context.getName() + " Started");
    }

    public void onFinish(ITestContext context) {
        System.out.println(context.getName() + " Finished");

    }

}