Feature: Search by for car
  As a customer
  I want to be able to search for any car of my choice
  so I can choose what to buy

  Scenario Outline: Customer can search for any car by location postcode
    Given I navigate to motors homepage
    When I enter "<Postcode>" into the postcode field
    And I select any car of my choice from Make(Any) dropdown
    And I select any model of my choice from Model(Any) dropdown
    And I select any price of my choice from Min Price drop down
    And I select any price of my choice from Max Price drop down
    And I click on search button
    Then a page is displayed showing the cars in the postcode
    And I click on one of the search results

  Examples:
  |Postcode|
  |BL2 2DE |
#  |M40 7EY |
#  |        |
#  |MMM NNN |
