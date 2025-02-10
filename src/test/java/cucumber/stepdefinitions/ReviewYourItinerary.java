package cucumber.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import utilities.ThreadLocalDriver;

public class ReviewYourItinerary extends BaseSteps{
    @Before
    public void ClearMytripPage() {
        if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Mobile")) {
            setupScreens(ThreadLocalDriver.getAppiumDriverThreadLocal());
        } else if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Online")){
            setupScreensOnline(ThreadLocalDriver.getRemoteWebDriverThreadLocal());
        } else {
            setupScreensOnlineLocal(ThreadLocalDriver.getWebDriverThreadLocal());
        }

    }
    @When("user clicks on Book")
    public void userClicksOnBook() {
        reviewYourItinerary.setClickonBookButton();
    }

    @When("user shifts to new page")
    public void usertonewpage() throws InterruptedException {
        reviewYourItinerary.newpage();
    }

    @Then("validate Review your itinerary page")
    public void validateReviewYourItineraryPage() {
    }
}
