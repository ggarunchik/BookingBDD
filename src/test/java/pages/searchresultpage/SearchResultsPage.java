package pages.searchresultpage;

import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;
import pages.components.HotelComponent;
import pages.components.SearchComponent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchResultsPage extends BasePage {

    private SearchComponent searchModal = new SearchComponent();
    private Map<String, HotelComponent> hotelComponents = new HashMap<>();
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

    public SearchResultsPage getAllHotels() {
        List<SelenideElement> hotelItems = $$(HotelComponent.getHOTEL_COMPONENT_CSS());
        List<SelenideElement> names = $$(HotelComponent.getNAME_COMPONENT_CSS());
        List<SelenideElement> ratings = $$(HotelComponent.getRATING_COMPONENT_CSS());
        List<SelenideElement> addresses = $$(HotelComponent.getADDRESS_COMPONENT_CSS());
        for (int i = 0; i < hotelItems.size(); i++) {
            hotelComponents.put(names.get(i).getText(),
                    new HotelComponent(
                            names.get(i),
                            ratings.get(i),
                            addresses.get(i)
                    ));
        }
        return this;
    }

    public SearchResultsPage isHotelPresent(String hotelName) {
        String actualHotelName = hotelComponents.get(hotelName).getHotelName().trim();
        assertThat("Can't find hotel with name: " + hotelName + " ", actualHotelName, is(hotelName));
        return this;
    }

    public SearchResultsPage isHotelRatingCorrect(String hotelName, String expectedRating) {
        String actualHotelRating = hotelComponents.get(hotelName).getHotelRating().trim();
        assertThat("Hotel rating is not correct", actualHotelRating, is(expectedRating));
        return this;
    }
}
