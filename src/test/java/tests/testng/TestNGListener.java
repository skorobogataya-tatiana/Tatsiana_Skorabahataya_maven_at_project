package tests.testng;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        /*System.out.println("Description on failure: " + result.getMethod().getDescription());
        System.out.println("Printing on failure: " + result.getStatus());*/
        TestrailReporter.reportResult("2353", result.getMethod().getDescription(), new Result(5));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        /*System.out.println("Description on success: " + result.getMethod().getDescription());
        System.out.println("Printing on success: " + result.getStatus());*/
        TestrailReporter.reportResult("2353", result.getMethod().getDescription(), new Result(1));
    }
}
