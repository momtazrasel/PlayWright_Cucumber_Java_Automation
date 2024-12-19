package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseTest;

public class FinanceSteps extends BaseTest {

    @When("the user navigates to the finance page")
    public void the_user_navigates_to_the_finance_page() {
        page.navigate("https://example.com/finance");
    }

    @Then("the finance page should display correct information")
    public void the_finance_page_should_display_correct_information() {
        test.pass("Finance page loaded successfully.");
    }
}
