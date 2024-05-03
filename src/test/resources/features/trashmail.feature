Feature: Email creation on Trashmail

  Scenario:
    Given I open Trashmail homepage
    When I indicate "tanchiktest87@gmail.com" as real email
    Then I can request a fake email creation
