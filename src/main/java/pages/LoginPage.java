package pages;

import com.microsoft.playwright.Page;
import com.aventstack.extentreports.ExtentTest;
import utilities.BaseTest;

public class LoginPage {
    private Page page;
    private ExtentTest test;

    // Constructor to inject the Page and ExtentTest instances
    public LoginPage(Page page, ExtentTest test) {
        this.page = page;
        this.test = test;
    }

    // Login method
    public void loginToApplication() {
        page.navigate("https://example.com/login");
        page.fill("input[name='username']", "admin");
        page.fill("input[name='password']", "password123");
        page.click("button[type='submit']");

        test.pass("Login performed successfully.");
        System.out.println("Login successful!");

        // Call screenshot method (in BaseTest)
        BaseTest.takeScreenshot(page, "login_success");
    }
}
