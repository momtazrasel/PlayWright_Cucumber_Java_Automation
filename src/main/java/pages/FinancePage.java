package pages;

import com.microsoft.playwright.Page;

public class FinancePage {
    private final Page page;

    public FinancePage(Page page) {
        this.page = page;
    }

    public void accessFinanceSection() {
        page.click("button#finance");
    }
}
