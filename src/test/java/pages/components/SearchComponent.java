package pages.components;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.searchresultpage.SearchResultsPage;
import pages.base.BaseSearchComponent;


import static com.codeborne.selenide.Selenide.$;

public class SearchComponent extends BaseSearchComponent {

    private static final By SEARCH_BOX_TITLE_CSS = By.cssSelector("[class='sb-searchbox__title-text']");
    private static final By SEARCH_INPUT_CSS = By.cssSelector("#ss");
    private static final By SEARCH_BUTTON_CSS = By.cssSelector(".sb-searchbox__button");
    private static final By CHECKIN_POP_UP_CSS = By.cssSelector("[class='c2-calendar']");
    private static final By CHECKIN_POP_UP_CLOSE_BTN_CSS = By.cssSelector(".c2-calendar-close-button");
    private static final By CHECKIN_CALENDAR_CSS = By.cssSelector("bui-calendar");

    @Override
    public BaseSearchComponent isModalOpened() {
        $(SEARCH_BOX_TITLE_CSS).waitUntil(Condition.visible, 20000);
        verifyCheckInPopUpClosed();
        return this;
    }

    public SearchResultsPage search(String hotelName) {
        $(SEARCH_INPUT_CSS).sendKeys(hotelName);
        $(SEARCH_BOX_TITLE_CSS).click();
        $(SEARCH_BUTTON_CSS).click();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.isPageOpened();
        return searchResultsPage;
    }

    public SearchComponent verifyCheckInPopUpClosed() {
        if ($(CHECKIN_POP_UP_CSS).isDisplayed()) {
            $(CHECKIN_POP_UP_CLOSE_BTN_CSS).click();
        } else if ($(CHECKIN_CALENDAR_CSS).isDisplayed()) {
            $(SEARCH_INPUT_CSS).click();
        }
        return this;
    }

    public SearchComponent setCheckInDate() {
        return this;
    }

    public SearchComponent setCheckoutDate() {
        return this;
    }

    public SearchComponent setAdultsNum() {
        return this;
    }

    public SearchComponent setChildrenNum() {
        return this;
    }

    public SearchComponent setRoomNum() {
        return this;
    }

    public SearchComponent isTravelForWork(Boolean bool) {
        return this;
    }
}
