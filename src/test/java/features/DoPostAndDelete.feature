Feature:
  Verify different Post & Delete operations using cucumber BDD


  Scenario: Verify POST operation for Profile
  Given I perform POST operation for "/posts/{profileNo}/profile" with body
    | name | profile |
    | Sams | 2       |
  Then I should see the body has name as "Sams"

  Scenario: Verify DELETE operation after POST
    Given I ensure to perform get operation for "/posts" with body as
      | id | title      | author      |
      | 6  | Death of the Wehrmach | Robert M. Citino |
    And I perform DELETE operation for "/posts/[postid]/"
      | postid |
      | 6      |
    And I perform GET operation with path parameter for "/posts/{postid}"
      | postid |
      | 6      |
    Then I should not see the body with title as "API Testing course"
