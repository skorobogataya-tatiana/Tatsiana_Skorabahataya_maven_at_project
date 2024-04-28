Feature: Work with select tags

  Scenario: Select green color
    Given I open Select Menu page
    When I select Green color "2" from select dropdown
    Then I see that "Green" color is selected

    Scenario: Select audi car
      Given I open Select Menu page
      When I select "audi" car from select list
      Then I see that "Audi" car is selected
