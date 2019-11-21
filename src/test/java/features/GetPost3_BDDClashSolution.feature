Feature:
    Demonstrate Solution to `Rest Assured - Cucumber` BDD style clash through BDD Style methods

  Scenario: Verify BDD CLASH SOLUTION one author of the post via BDD style method
      Given I perform BDD style GET operation for "/post"
      And I perform BDD style GET for post number "1"
      Then I BDD style should see the author name as "saransh1337"


  Scenario: Verify BDD CLASH SOLUTION all authors of posts via BDD style method
    Given I perform BDD style GET operation for "/post"
    Then I BDD style should see all the author names