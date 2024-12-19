package utilities;

import com.microsoft.playwright.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import pages.LoginPage;

import java.io.File;
import java.nio.file.Paths;

public class BaseTest {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void initializePlaywrightAndReports() {
        // Initialize Playwright
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
    }

    public static void login() {
        LoginPage loginPage = new LoginPage(page, test);
        loginPage.loginToApplication();
    }

    public static void tearDown() {
        if (extent != null) {
            extent.flush();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

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
