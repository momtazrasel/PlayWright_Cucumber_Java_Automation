package utilities;

import com.microsoft.playwright.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.LoginPage;

import java.io.File;
import java.nio.file.Paths;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @Before
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();

        // Initialize Extent Reports
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }

        test = extent.createTest("Test Initialization");

        // Call LoginPage and perform login
        LoginPage loginPage = new LoginPage(page, test);
        loginPage.loginToApplication();
    }

    @After
    public void teardown() {
        extent.flush();
        browser.close();
        playwright.close();
    }

    // Static takeScreenshot method
    public static void takeScreenshot(Page page, String stepName) {
        String directory = "screenshots";
        String path = directory + "/" + stepName + ".png";

        // Create folder if it doesn't exist
        File screenshotsDir = new File(directory);
        if (!screenshotsDir.exists()) {
            screenshotsDir.mkdirs();
        }

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
        System.out.println("Screenshot taken: " + path);
    }
}
