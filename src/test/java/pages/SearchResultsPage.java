package pages;

import model.SearchModal;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class SearchResultsPage extends BasePage {

    private SearchModal searchModal = new SearchModal();
    private String SEARCH_RESULTS_PAGE = "https://www.booking.com/searchresults.en-gb.html";

    @Override
    public SearchResultsPage openPage() {
        open(SEARCH_RESULTS_PAGE);
        isPageOpened();
        return this;
    }

    @Override
    public SearchResultsPage isPageOpened() {
        searchModal.isModalOpened();
        return this;
    }

    public List<String> getAllHotels() {
        return null;
    }
}
