package TestNG;

import Functions.Generic;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Objects;

public class Listener implements ITestListener {

    public void onStart(ITestContext context) {

        System.out.println("onStart method started");
    }

    public void onFinish(ITestContext context) {

        System.out.println("onFinish method started");
    }

    public void onTestStart(ITestResult result) {

        System.out.println("New Test Started " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {

        System.out.println("onTestSuccess Method " + result.getName());
    }

    public void onTestFailure(ITestResult result) {

        System.out.println("onTestFailure Method " + result.getName());
        try {
            Generic.getScreenshot("FailedTestScreenshots_" + result.getName());
            if(Objects.equals(result.getName(), "OpenBrowserAndVerifyUI")) {
                Generic.createScreenshotLink(1, 12, result.getName());
            } else if(Objects.equals(result.getName(), "ClickCustomerLoginAndSelectName")) {
                Generic.createScreenshotLink(2, 12, result.getName());
            } else if(Objects.equals(result.getName(), "ClickLoginButton")) {
                Generic.createScreenshotLink(3, 12, result.getName());
            } else if(Objects.equals(result.getName(), "SelectAccountNumber")) {
                Generic.createScreenshotLink(4, 12, result.getName());
            } else if(Objects.equals(result.getName(), "AddDepositAmount")) {
                Generic.createScreenshotLink(5, 12, result.getName());
            } else if(Objects.equals(result.getName(), "WithdrawTheAmount")) {
                Generic.createScreenshotLink(6, 12, result.getName());
            } else if(Objects.equals(result.getName(), "VerifyTransactionsDetails")) {
                Generic.createScreenshotLink(7, 12, result.getName());
            } else if(Objects.equals(result.getName(), "ClickLogOutAndCloseBrowser")) {
                Generic.createScreenshotLink(8, 12, result.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {

        System.out.println("onTestSkipped Method " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        System.out.println("onTestFailedButWithinSuccessPercentage " + result.getName());
    }

}
