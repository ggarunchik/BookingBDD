package pages.components;

import com.codeborne.selenide.SelenideElement;

public class HotelComponent {
    private SelenideElement name;
    private SelenideElement rating;
    private SelenideElement address;
    private static String RATING_COMPONENT_CSS = ".bui-review-score__badge";
    private static String ADDRESS_COMPONENT_CSS = "[data-google-track=\"Click/Action: sr_map_link_used\"]";
    private static String NAME_COMPONENT_CSS = ".sr-hotel__name";
    private static String HOTEL_COMPONENT_CSS = ".sr_item";

    public HotelComponent(SelenideElement name, SelenideElement rating, SelenideElement address) {
        this.name = name;
        this.rating = rating;
        this.address = address;
    }

    public static String getRATING_COMPONENT_CSS() {
        return RATING_COMPONENT_CSS;
    }

    public static String getADDRESS_COMPONENT_CSS() {
        return ADDRESS_COMPONENT_CSS;
    }

    public static String getNAME_COMPONENT_CSS() {
        return NAME_COMPONENT_CSS;
    }

    public static String getHOTEL_COMPONENT_CSS() {
        return HOTEL_COMPONENT_CSS;
    }

    public void clickOnMap() {
        address.click();
    }

    public String getHotelName() {
        return name.getText();
    }

    public String getHotelRating() {
        return rating.getText();
    }
}