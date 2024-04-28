Feature: Google search

  Scenario: Search in Google of copy-pasted title value from W3School page
    Given I open W3School java page
    When I copy title value of the page
    And I open Google page
    And I paste copied value on Google search field and trigger search
    Then I see that all search results contain word "tutorial"
