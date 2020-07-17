Feature: Search by for car
  As a customer
  I want to be able to search for any car of my choice
  so I can choose what to buy

  Scenario Outline: Customer can search for any car by location postcode
    Given I navigate to motors homepage
    When I enter "<Postcode>" into the postcode field
    And I select "<CarType>" from Make dropdown
    And I select "<CarModel>" from Model dropdown
    And I select "<MinPrice>" from Min Price drop down
    And I select "<HighestPrice>" out of the HighestPrice drop down
    And I click on search button
    Then the search for "<Postcode>" is displayed
    And I click on one of the search results

  Examples:
  |Postcode|CarType|CarModel|MinPrice| HighestPrice|
  |BL2 2DE |Hyundai|i30     |£2,000  | £6,000      |


#  |M40 7EY |BMW    |8 Series|£4,000  | £20,000     |
#  |        |
#  |MMM NNN |
#   And I select "<HighestPrice>" from Max Price drop down

# And I select "<MaximPrice>" from Max Price drop down
 # |Maximprice|
  #|£6,000 |
  #|£20,000 |


  @error
  Scenario Outline: Customer cannot search for any car without location postcode
    Given I navigate to motors homepage
    When I did not enter "<Postcode>" into the postcode field
    And I select "<CarType>" from Make dropdown
    And I select "<CarModel>" from Model dropdown
    And I select "<MinPrice>" from Min Price drop down
    And I select "<HighestPrice>" out of the HighestPrice drop down
    And I click on search button
    Then then an error page is displayed

    Examples:
      |Postcode|CarType|CarModel|MinPrice| HighestPrice|
      |        |BMW    |4 Series|£2,000  | £12,500     |
#      |        |Audi   |A8      |£4,000  | £15,000     |