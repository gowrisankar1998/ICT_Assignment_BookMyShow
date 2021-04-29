package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;

public class TestNGListeners implements ITestListener {
    WebDriver driver=null;

    public void onTestStart(ITestResult result) {
        System.out.println("***************Test Started*****************   " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("***************Test Successful*****************   " + result.getName());
    }
    public void onTestFailure(ITestResult result) {
        System.out.println("***************Test Failed*****************  " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("***************Test Skipped*****************  " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {
        System.out.println("***************Test Completed*****************  " + context.getName());
    }

}
