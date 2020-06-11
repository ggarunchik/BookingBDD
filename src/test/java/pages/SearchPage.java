package pages;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {

    String searchFieldLocatorCss = "#ss";
    String searchButtonCss = ".sb-searchbox__button";

    public void openPage() {
        open("https://www.booking.com/searchresults.en-gb.html\n");
    }

    public void search(String hotelName) {
        $(searchFieldLocatorCss).sendKeys(hotelName);
        $(searchButtonCss).click();
    }

    public List<String> getAllHotels() {
        return null;
    }

}
