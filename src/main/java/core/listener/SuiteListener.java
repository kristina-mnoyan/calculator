package core.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import core.logger.Logger;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

@Log4j
public class SuiteListener extends TestListenerAdapter {
    private static final String SEPARATOR = "====================================================================";
    private final ExtentReports extent;

    public SuiteListener() {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./target/__results.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Override
    @SneakyThrows
    public void onTestFailure(ITestResult iTestResult) {
        ExtentTest failLogger = extent.createTest(iTestResult.getName());
        failLogger.log(Status.FAIL, "Failed ===> " + iTestResult.getThrowable().getMessage());
        extent.flush();

        log.info(Logger.Color.RED + "Failed ---> " + iTestResult.getTestClass().getName().split("\\.")[2] + " -> " + iTestResult.getName() + Logger.Color.RESET);
        log.info(Logger.Color.RED + SEPARATOR + Logger.Color.RESET);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info(Logger.Color.RED + SEPARATOR + Logger.Color.RESET);
        log.info(Logger.Color.RED + " STARTED ---> " + iTestResult.getTestClass().getName().split("\\.")[2] + " -> " + iTestResult.getName() + Logger.Color.RESET);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentTest passLogger = extent.createTest(iTestResult.getName());
        passLogger.log(Status.PASS, "Passed");
        extent.flush();

        log.info(Logger.Color.RED + "FINISHED ---> " + iTestResult.getTestClass().getName().split("\\.")[2] + " -> " + iTestResult.getName() + Logger.Color.RESET);
        log.info(Logger.Color.RED + SEPARATOR + Logger.Color.RESET);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ExtentTest skipLogger = extent.createTest(iTestResult.getName());
        skipLogger.log(Status.SKIP, "Skipped");
        extent.flush();

        log.info(Logger.Color.RED + "SKIPPED ---> " + iTestResult.getName() + Logger.Color.RESET);
        log.info(Logger.Color.RED + SEPARATOR + Logger.Color.RESET);
    }
}
