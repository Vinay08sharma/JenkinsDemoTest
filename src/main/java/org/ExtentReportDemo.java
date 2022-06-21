package org;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class ExtentReportDemo {
    @BeforeTest
    public static ExtentReports config(){
        String path = System.getProperty("user.dir") + File.pathSeparator + "reports" + File.pathSeparator + "index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Report");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("QA","Vinay");
        extentReports.flush();
        return extentReports;
    }
}
