Feature: Validating Booking search
  Scenario: Search for hotel Loop Hotel
    Given Search hotel "Loop Hotel"
    When User search for hotel
    Then Hotel "Loop Hotel Vilnius" is displayed on search results page
    And Hotel rating is "9,2"