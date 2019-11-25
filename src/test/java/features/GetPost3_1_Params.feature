Feature:
  Demonstrate Use of Query Params

  Scenario: Verify a GET request using Query  Params in the request
    Given I perform BDD style GET operation for "/post"
    And I perform GET using QueryParams for post number "1"
    Then I BDD style should see the author name as "saransh1337"