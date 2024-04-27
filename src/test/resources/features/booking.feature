Feature: Search hotels on booking

  Scenario: Search hotels in Paris and filter them on rate
    Given I open booking homepage
    When I input and submit "Paris" city name in search field
    And I select startDate in 1 days and endDate in 2 days
    And I add 2 more adults and 1 more rooms in occupancy
    And I trigger searching of options
    And I filter the results on rate 6+
    And I sort results from lowest rate to highest
    Then I see that the rate of the first hotel in the list is not lower than 6

  Scenario: Search hotel in London
    Given I open booking homepage
    And I input and submit "London" city name in search field
    When I scroll to tenth hotel in search results
    And I change background and font color of the hotel card
    Then I can make a screenshot of hotel card

  Scenario: Search for hotel in Prague with high rate
    Given I open booking homepage
    When I input and submit "Prague" city name in search field
    And I click out of calendar component
    And I sort results from highest to lowest
    And I open first hotel in the search list
    Then I see that rate of the opened hotel is bigger than 8
