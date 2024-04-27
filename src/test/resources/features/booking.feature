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
