Feature:
  Verify different GET operations using Arrange Act Assert BDD; fixes clash of  RestAssured - Cucumber BDD styles

  Scenario: Verify via AAA_BDD one author of the post
    Given I AAA_BDD perform GET operation for "/post"
    And I AAA_BDD perform GET for the post number "1"
    Then I AAA_BDD should see the author name as "saransh1337"
