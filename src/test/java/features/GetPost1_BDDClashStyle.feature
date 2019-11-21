Feature:
    Verify different GET operations using cucumber BDD

    Scenario: Verify one author of the post
        Given I perform GET operation for "/post"
        And I perform GET for the post number "1"
        Then I should see the author name as "saransh1337"


    Scenario: Verify one author BDD style
        Given I perform GET operation for "/post"
        And I perform GET for the post number "1" THEN see author name as "saransh1337"


