Feature:
  Verify different Post & Delete operations using cucumber BDD


  Scenario: Verify POST operation for Profile
  Given I perform POST operation for "/posts/{profileNo}/profile" with body
    | name | profile |
    | saransh1337 | 3       |
  Then I should see the body has name as "saransh1337"

  Scenario: Verify DELETE operation after POST
    Given I ensure to perform get operation for "/posts" with body as
      | id | title                  | author           |
      | 9  | Death of the Wehrmacht | Robert M. Citino |
    And I perform DELETE operation for "/posts/{postid}/"
      | postid |
      | 9      |
    Then I should not see the body with title as "API Testing course"
