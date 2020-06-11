package model;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.SearchResultsPage;


import static com.codeborne.selenide.Selenide.$;

public class SearchModal extends BaseSearchModal {

    private static final By SEARCH_BOX_TITLE_CSS = By.cssSelector("[class='sb-searchbox__title-text']");
    private static final By SEARCH_INPUT_CSS = By.cssSelector("#ss");
    private static final By SEARCH_BUTTON_CSS = By.cssSelector(".sb-searchbox__button");
    private static final By CHECKIN_POP_UP_CSS = By.cssSelector("[class='c2-calendar']");
    private static final By CHECKIN_POP_UP_CLOSE_BTN_CSS = By.cssSelector("[c2-calendar-close-button-icon']");

    @Override
    public BaseSearchModal isModalOpened() {
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

    public SearchModal verifyCheckInPopUpClosed(){
        if($(CHECKIN_POP_UP_CSS).isDisplayed()){
            $(CHECKIN_POP_UP_CLOSE_BTN_CSS).click();
        }
        return this;
    }

    public SearchModal setCheckInDate(){
        return this;
    }

    public SearchModal setCheckoutDate(){
        return this;
    }

    public SearchModal setAdultsNum(){
        return this;
    }

    public SearchModal setChildrenNum(){
        return this;
    }

    public SearchModal setRoomNum(){
        return this;
    }

    public SearchModal isTravelForWork(Boolean bool){
        return this;
    }
}
