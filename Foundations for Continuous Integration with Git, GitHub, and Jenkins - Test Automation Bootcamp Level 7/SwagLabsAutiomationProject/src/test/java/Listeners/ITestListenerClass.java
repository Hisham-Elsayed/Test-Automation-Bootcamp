package Listeners;

import Utilities.LogsUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass implements ITestListener {
    public void onTestStart(ITestResult result) {
        LogsUtils.info("Test Case " + result.getName() + " Started");
    }

    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("Test Case " + result.getName() + " Succeeded");
    }

    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("Test Case " + result.getName() + " Skipped");
    }
}
