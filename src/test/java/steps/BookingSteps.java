package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

public class BookingSteps {
    String hotelName;
    private SearchPage searchPage;

    @Given("Search hotel {string}")
    public void hotelName(String hotelName) {
    }

    @When("User search for hotel")
    public void userSearchForHotel() {
    }

    @Then("Hotel {string} is displayed on search results page")
    public void hotelIsDisplayedOnSearchResultsPage(String arg0) {
    }

    @And("Hotel rating is {string}")
    public void hotelRatingIs(String arg0) {
    }
}
