@ClearMyTrip1Page
Feature: To Switch To The New Page of clear MyTrip

  @ReviewYourItinerary

  Scenario Outline: Validate Review your itinerary page
    Given user is on cleartrip home page
    When the user clicks on where from dropdown
    Then different cities are displayed in dropdown
    When user selects from "<city>"
    And user clicks on the where to dropdown
    Then different cities are displayed in where to dropdown
    When user selects "<tocity>"
    And select the from and to date
    And click on search flights
    Then flights should be listeds
    When user clicks on Book
    When user shifts to new page
    Then validate Review your itinerary page

    Examples:
      | city | tocity |
      | BLR  | HYD    |

