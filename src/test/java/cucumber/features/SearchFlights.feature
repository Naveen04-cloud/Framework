@clearmytripFeature
  Feature: feature to test the clear my trip homepage functionality
@SearchFlights
    Scenario Outline:Validate search flights
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

      Examples:
      |city|tocity|
      |BLR |HYD    |


