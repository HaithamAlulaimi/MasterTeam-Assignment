package helper;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class RetryAnalyzer implements IRetryAnalyzer {

    private final int maxRetryCount = 2;
    private int retryCount = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess() && retryCount < maxRetryCount) {
            String message = getRetryMessage(iTestResult);
            Reporter.log(message);
            retryCount++;
            return true;
        }
        return false;
    }

    private String getRetryMessage(ITestResult iTestResult) {
        return Thread.currentThread().getName()
                + ": Error in "
                + iTestResult.getName()
                + " Retrying "
                + ((maxRetryCount + 1) - retryCount)
                + " more times";
    }
}