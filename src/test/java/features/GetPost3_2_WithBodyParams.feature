Feature:
  Demonstrate POST with body params in BDD Style

  Scenario: Perform POST with body params in BDD style
    Given I perform POST operation for "/posts"
    Then I should see verify GET parameter