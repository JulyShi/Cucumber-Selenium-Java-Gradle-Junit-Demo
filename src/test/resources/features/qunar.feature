
Feature: Search in qunar website

  Scenario Outline: Search in qunar website
    Given I open qunar website and validate the title
    When I click "<tag>"
    And I input the Free Trip search page
    Then the search result displayed
    Examples:
    |tag   |
    |自由行 |



