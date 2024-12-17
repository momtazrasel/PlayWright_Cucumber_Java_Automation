package pages;

import com.microsoft.playwright.Page;

public class BudgetPage {
    private final Page page;

    public BudgetPage(Page page) {
        this.page = page;
    }

    public void accessBudgetSection() {
        page.click("button#budget");
    }
}
