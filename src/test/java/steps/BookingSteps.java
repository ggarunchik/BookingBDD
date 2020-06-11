package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.SearchItemModule;
import model.SearchModal;
import pages.SearchResultsPage;

public class BookingSteps {
    String hotelName;
    private SearchModal searchModal = new SearchModal();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private SearchItemModule searchItemModule;

    @Given("Keyword for search hotel is {string}")
    public void keywordForSearchHotelIs(String keyword) {
        searchItemModule = new SearchItemModule(keyword);
    }

    @When("User search for hotel")
    public void userSearchForHotel() {
        searchResultsPage.openPage();
        searchModal.search(searchItemModule.getSearchHotelValue());
    }

    @Then("Hotel {string} is displayed on search results page")
    public void hotelIsDisplayedOnSearchResultsPage(String arg0) {
    }

    @And("Hotel rating is {string}")
    public void hotelRatingIs(String arg0) {
    }
}
