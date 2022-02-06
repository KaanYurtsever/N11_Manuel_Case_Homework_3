Feature: n11 search page filtering

  @filter
  Scenario: Search a product and filters it
    Given User opens the browser and goes to home page
    When User searches a product "telefon"
    Then User selects some filters
