package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.SearchItemModel;
import pages.components.SearchComponent;
import pages.searchresultpage.SearchResultsPage;

public class BookingSteps {
    private SearchComponent searchModal = new SearchComponent();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private SearchItemModel searchItemModule;


    @Given("Keyword for search hotel is {string}")
    public void keywordForSearchHotelIs(String keyword) {
        searchItemModule = new SearchItemModel(keyword);
    }

    @When("User search for hotel")
    public void userSearchForHotel() {
        searchResultsPage.openPage();
        searchModal.search(searchItemModule.getSearchHotelValue());
    }

    @Then("Hotel {string} is displayed on search results page")
    public void hotelIsDisplayedOnSearchResultsPage(String hotelName) {
        searchResultsPage
                .getAllHotels()
                .isHotelPresent(hotelName);
    }

    @And("Rating of {string} is {string}")
    public void hotelRatingIs(String hotelName, String hotelRating) {
        searchResultsPage.isHotelRatingCorrect(hotelName, hotelRating);
    }
}
