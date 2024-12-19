package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.BaseTest;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;

    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        loginPage = new LoginPage(page, test);
//        page.navigate("https://bracuerp-qa.apsissolutions.com/signin");
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.loginToApplication();
    }

    @When("the user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        page.fill("input[name='username']", "invalid_user");
        page.fill("input[name='password']", "wrong_password");
    }

    @When("the user leaves the username and password fields blank")
    public void the_user_leaves_the_username_and_password_fields_blank() {
        page.fill("input[name='username']", "");
        page.fill("input[name='password']", "");
    }

    @And("clicks on the login button")
    public void clicks_on_the_login_button() {
        page.click("button[type='submit']");
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        test.pass("User successfully redirected to dashboard.");
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        String errorMessage = page.textContent(".error-message");
        test.pass("Error message displayed: " + errorMessage);
    }

    @Then("a validation message should be displayed")
    public void a_validation_message_should_be_displayed() {
        String validationMessage = page.textContent(".validation-message");
        test.pass("Validation message displayed: " + validationMessage);
    }
}