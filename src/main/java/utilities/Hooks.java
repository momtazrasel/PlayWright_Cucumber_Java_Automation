package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseTest;

public class Hooks {

    @Before
    public void setup() {
        BaseTest.initializePlaywrightAndReports();
        BaseTest.login();
    }

    @After
    public void teardown() {
        BaseTest.tearDown();
    }
}
