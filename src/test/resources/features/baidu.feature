Feature: Baidu Search


  Scenario: results are shown
    Given the page is open "https://www.baidu.com/"
    When I search for "BDD"
    Then a browser title should contains "BDD"