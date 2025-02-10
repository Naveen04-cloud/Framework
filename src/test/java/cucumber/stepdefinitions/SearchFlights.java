package cucumber.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import utilities.ThreadLocalDriver;

/**
 * this class contains java implementation for steps in feature files
 */

public class SearchFlights extends BaseSteps {

  @Before
  public void setupClearMyTrip() {
    if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Mobile")) {
      setupScreens(ThreadLocalDriver.getAppiumDriverThreadLocal());
    } else if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Online")){
      setupScreensOnline(ThreadLocalDriver.getRemoteWebDriverThreadLocal());
    } else {
      setupScreensOnlineLocal(ThreadLocalDriver.getWebDriverThreadLocal());
    }
  }

  @Given("user is on cleartrip home page")
  public void userisoncleartriphomepage() {
      searchFlightsPage.userisoncleartriphomepage();
      searchFlightsPage.closePopUp();
  }


  @When("the user clicks on where from dropdown")
  public void theUserClicksOnWhereFromDropdown() {
    searchFlightsPage.WhereFromDropdown();
  }

  @Then("different cities are displayed in dropdown")
  public void differentCitiesAreDisplayedInDropdown() {
    System.out.println(searchFlightsPage.differentcitiesaredisplayedindropdown());
  }

  @When("user selects from {string}")
  public void userSelectsFrom(String city) {
    searchFlightsPage.userselectsfromcity(city);
  }

  @And("user clicks on the where to dropdown")
  public void userClicksOnTheWhereToDropdown() {
    searchFlightsPage.wheretodropdown();
  }

  @Then("different cities are displayed in where to dropdown")
  public void differentCitiesAreDisplayedInWhereToDropdown() {
    searchFlightsPage.differentcitiesaredisplayedinwheretodropdown();
  }

  @When("user selects {string}")
  public void userSelectsTo(String tocity) {

    searchFlightsPage.userSelectToCity(tocity);
  }

  @And("select the from and to date")
  public void selectTheFromAndToDate() {
    searchFlightsPage.clickFromDate();
    searchFlightsPage.selectFromDate();
    searchFlightsPage.clickReturnDate();
    searchFlightsPage.ReturnDate();

  }

  @And("click on search flights")
  public void clickOnSearchFlights() {
    searchFlightsPage.searechFlights();
  }

  @Then("flights should be listeds")
  public void flightsShouldBeListeds() {
    searchFlightsPage.flightsList();
  }


}
