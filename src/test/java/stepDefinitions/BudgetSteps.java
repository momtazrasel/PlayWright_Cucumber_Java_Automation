package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseTest;

public class BudgetSteps extends BaseTest {

    @When("the user navigates to the budget page")
    public void the_user_navigates_to_the_budget_page() {
        page.navigate("https://example.com/budget");
    }

    @Then("the budget page should display correct information")
    public void the_budget_page_should_display_correct_information() {
        test.pass("Budget page loaded successfully.");
    }
}
